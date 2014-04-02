cdk-scala-examples
==================

This is an example project that uses the CDK from Scala. The project uses [SBT](http://www.scala-sbt.org/) 
to compile and will automatically fetch the CDK dependency. A selection of tasks
from the [Chemical Toolkit Rosetta Wiki](http://ctr.wikia.com/) are included and can be run via `sbt` from the command line.

### Examples

- [Convert a SMILES string to canonical SMILES](http://ctr.wikia.com/wiki/Convert_a_SMILES_string_to_canonical_SMILES) `$ sbt 'run-main ctr.CanSmi'`
- [Ring counts in a SMILES file](http://ctr.wikia.com/wiki/Ring_counts_in_a_SMILES_file) `$ sbt 'run-main ctr.CircuitRank'`
- [Report SDfile reconds with a weight range](http://ctr.wikia.com/wiki/Report_how_many_SD_file_records_are_within_a_certain_molecular_weight_range) `$ sbt 'run-main ctr.MolWeight'`


