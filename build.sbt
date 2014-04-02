name := "cdk-scala"

version := "1.0"

libraryDependencies += "org.openscience.cdk" % "cdk-bundle" % "1.5.6-SNAPSHOT"

resolvers += "ebi-releases"   at "http://www.ebi.ac.uk/intact/maven/nexus/content/repositories/ebi-repo/"

resolvers += "ebi-snapshots"  at "http://www.ebi.ac.uk/intact/maven/nexus/content/repositories/ebi-repo-snapshots/"

resolvers += "jni-inchi-repo" at "http://jni-inchi.sourceforge.net/m2repo"

resolvers += "jnati" at "http://jnati.sourceforge.net/m2repo"

