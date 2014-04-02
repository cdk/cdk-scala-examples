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
import org.openscience.cdk.graph._

/**
 * http://ctr.wikia.com/wiki/Find_the_graph_diameter
 * 
 * @author John May
 */
object GraphDiameter extends App {

  val mol = "CC(C)C(C(=O)NC(=O)C1CCCN1C(=O)C(C)NC(=O)C(C)NC(=O)CCC(=O)OC)NC2=CC=C(C=C2)[N+](=O)[O-]"
  
  val apsp = new AllPairsShortestPaths(mol)
  val vs   = 0 until mol.getAtomCount
  
  val diam = vs.map(v => (v, apsp.from(v)))
               .flatMap(x => vs.filter(_ > x._1)
                               .map(x._2.distanceTo))
               .foldLeft(0)(Math.max)
  
  println(diam)
  
  implicit def smiAutoParser(str: String): IAtomContainer = {
    val bldr = SilentChemObjectBuilder.getInstance()
    new SmilesParser(bldr).parseSmiles(str)
  }
}
