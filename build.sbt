//import AssemblyKeys._ // put this at the top of the file
//assemblySettings
assemblyJarName in assembly := "FileProcessor.jar"


name := "HW1_HDFS"
version := "1.0"
scalaVersion := "2.11.7"



libraryDependencies ++= Seq(
  "org.apache.hadoop" % "hadoop-client" % "2.7.1"
)

assemblyMergeStrategy in assembly := {
  case "application.conf"                                   => MergeStrategy.concat
  case PathList("org", "apache", "hadoop", "yarn", xs @ _*) => MergeStrategy.first
  case PathList("org", "apache", "commons", xs @ _*)        => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
    