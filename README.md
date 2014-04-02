cdk-scala-examples
==================

This is an example project that uses the CDK from Scala. The project uses [SBT](http://www.scala-sbt.org/) 
to compile and will automatically fetch the CDK dependency. A selection of tasks
from the [Chemical Toolkit Rosetta Wiki](http://ctr.wikia.com/) are included and can be run via `sbt` from the command line.


#### [Convert a SMILES string to canonical SMILES](http://ctr.wikia.com/wiki/Convert_a_SMILES_string_to_canonical_SMILES) 
Run: `$ sbt 'run-main ctr.CanSmi'` <br />
Src: [`ctr.CanSmi.scala`](https://github.com/cdk/cdk-scala-examples/tree/master/src/main/scala/ctr/CanSmi.scala)

#### [Ring counts in a SMILES file](http://ctr.wikia.com/wiki/Ring_counts_in_a_SMILES_file) 
Run: `$ sbt 'run-main ctr.CircuitRank'` <br />
Src: [`ctr.CircuitRank.scala`](https://github.com/cdk/cdk-scala-examples/tree/master/src/main/scala/ctr/CircuitRank.scala)

#### [Report SDfile reconds with a weight range](http://ctr.wikia.com/wiki/Report_how_many_SD_file_records_are_within_a_certain_molecular_weight_range) 
Run: `$ sbt 'run-main ctr.MolWeight'` <br />
Src: [`ctr.MolWeight.scala`](https://github.com/cdk/cdk-scala-examples/tree/master/src/main/scala/ctr/MolWeight.scala)

#### [Unique SMARTS matches against a SMILES string](http://ctr.wikia.com/wiki/Unique_SMARTS_matches_against_a_SMILES_string) 
Run: `$ sbt 'run-main ctr.SmaMatch'` <br />
Src: [`ctr.SmaMatch.scala`](https://github.com/cdk/cdk-scala-examples/tree/master/src/main/scala/ctr/SmaMatch.scala)

#### [Find the graph diameter](http://ctr.wikia.com/wiki/Find_the_graph_diameter) 
Run: `$ sbt 'run-main ctr.GraphDiameter'` <br />
Src: [`ctr.GraphDiameter.scala`](https://github.com/cdk/cdk-scala-examples/tree/master/src/main/scala/ctr/GraphDiameter.scala)


