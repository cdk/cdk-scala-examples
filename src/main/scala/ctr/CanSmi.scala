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
import org.openscience.cdk.aromaticity.{ElectronDonation, Aromaticity}

/**
 * http://ctr.wikia.com/wiki/Convert_a_SMILES_string_to_canonical_SMILES
 * @author John May
 */
object CanSmi extends App {

  val smis    = List("CN2C(=O)N(C)C(=O)C1=C2N=CN1C",
                     "CN1C=NC2=C1C(=O)N(C)C(=O)N2C")
  
  // SmilesGenerator.generic isomeric or absolute 
  val cansmis = smis.map(SmilesGenerator.unique.create(_))

  println(cansmis)
  
  implicit def smiAutoParser(str: String): IAtomContainer = {
    val bldr = SilentChemObjectBuilder.getInstance()
    new SmilesParser(bldr).parseSmiles(str)
  }
}
