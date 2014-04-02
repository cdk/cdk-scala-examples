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

import org.openscience.cdk.silent.SilentChemObjectBuilder
import org.openscience.cdk.smiles.{SmilesGenerator, SmilesParser}
import org.openscience.cdk.interfaces.IAtomContainer
import org.openscience.cdk.aromaticity.Aromaticity
import org.openscience.cdk.graph.{Cycles, ConnectedComponents, GraphUtil}
import java.io.{FileInputStream, BufferedInputStream}
import java.util.zip.GZIPInputStream
import scala.io.Source

/**
 * http://ctr.wikia.com/wiki/Ring_counts_in_a_SMILES_file
 * @author John May
 */
object CircuitRank extends App {

  val s  = Source.fromInputStream(gis("benzodiazepine.smi.gz"))
  val ms = s.getLines().map(smipar)

  // high-level uses the Cycles facade
  //  - mcb / sssr
  //  - relevant 
  //  - essential
  //  - all
  //  - triplet (aka. CACTVS ESSSR+Envelopes)
  val cs = ms.map(Cycles.mcb).map(_.numberOfCycles())
  
  // low-level (note stream of compounds so can't iterate twice)
  // val cs = ms.map(circuitRank)
  
  // lowlevel
  def circuitRank(m : IAtomContainer) = {
    val v = m.getAtomCount
    val e = m.getBondCount
    val c = new ConnectedComponents(m).nComponents()
    e - v + c
  }
  
  implicit def adjlist(m : IAtomContainer) : Array[Array[Int]] =
    GraphUtil.toAdjList(m)
  
  implicit def smipar(str: String): IAtomContainer = {
    val bldr = SilentChemObjectBuilder.getInstance()
    new SmilesParser(bldr).parseSmiles(str)
  }

  def gis(s: String) = new GZIPInputStream(new BufferedInputStream(getClass.getResourceAsStream(s)))

}
