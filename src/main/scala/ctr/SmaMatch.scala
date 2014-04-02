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
import org.openscience.cdk.smiles.SmilesParser
import org.openscience.cdk.smiles.smarts.SMARTSQueryTool

/**
 * http://ctr.wikia.com/wiki/Unique_SMARTS_matches_against_a_SMILES_string
 * @author John May
 */
object SmaMatch extends App {
  
  val sma = "*1**1"
  val smi = "C1CC12C3(C24CC4)CC3"
  
  val bldr   = SilentChemObjectBuilder.getInstance()
  val smipar = new SmilesParser(bldr)
  
  // XXX: waiting on patch review for improved API
  val sqt = new SMARTSQueryTool(sma, bldr)
  val mol = smipar.parseSmiles(smi)
  
  sqt.matches(mol)
  
  println("matches: " + sqt.countMatches)
  println("unique atom matches: " + sqt.getUniqueMatchingAtoms.size)
  
}
