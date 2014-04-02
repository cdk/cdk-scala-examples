/*
 * Copyright (c) 2014. The Chemistry Development Kit (CDK) project
 *
 * Contact: cdk-devel@lists.sourceforge.net
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * All we ask is that proper credit is given for our work, which includes
 * - but is not limited to - adding the above copyright notice to the beginning
 * of your source code files, and to any copyright notice that you may distribute
 * with programs based on this work.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package ctr

import scala.collection.JavaConverters._

import org.openscience.cdk.silent.{AtomContainer, SilentChemObjectBuilder}
import org.openscience.cdk.smiles.SmilesParser
import org.openscience.cdk.interfaces.{IAtom, IAtomContainer}
import java.io.BufferedInputStream
import java.util.zip.GZIPInputStream
import org.openscience.cdk.config.{Elements, Isotopes}
import org.openscience.cdk.io.MDLV2000Reader

/**
 * http://ctr.wikia.com/wiki/Report_how_many_SD_file_records_are_within_a_certain_molecular_weight_range
 * @author John May
 */
object MolWeight extends App {

  val isotopes = Isotopes.getInstance()
  val hMass    = isotopes.getNaturalMass(Elements.Hydrogen.toIElement)
  
  val ms   = molfileStrm("benzodiazepine.sdf.gz")
  val n    = ms.map(weight).count(w => 300 <= w && w <= 400)
  
  println(n)
  
  def weight(m: IAtomContainer) = m.atoms.asScala.foldLeft(0d)(_ + natmass(_))
  
  def natmass(a : IAtom) = isotopes.getNaturalMass(a) + (hMass * a.getImplicitHydrogenCount)

  def molfileStrm(str : String) : Stream[IAtomContainer] = molfileStrm(new MDLV2000Reader(gis(str)))
  
  def molfileStrm(mdlr : MDLV2000Reader) : Stream[IAtomContainer] = {
    val m = mdlr.read(new AtomContainer(0, 0, 0, 0))
    if (m != null) {
      Stream.cons(m, molfileStrm(mdlr))
    } else {
      mdlr.close()
      Stream()
    }
  }
  
  def gis(s: String) = new GZIPInputStream(new BufferedInputStream(getClass
                                                                   .getResourceAsStream(s)))

  implicit def elem(a : IAtom) = {
    Elements.ofNumber(a.getAtomicNumber)
  }
  
  implicit def smipar(str: String): IAtomContainer = {
    val bldr = SilentChemObjectBuilder.getInstance()
    new SmilesParser(bldr).parseSmiles(str)
  }

  

}
