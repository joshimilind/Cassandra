name := "cassandra"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "com.datastax.cassandra" % "cassandra-driver-core" % "3.3.2")

//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.16"

/*
Create “test” keyspace in cassandra database .
Write CQL script to create cassandra table “base_pos_data” described below in the key space.

Write scala class code using “cassandra-driver-core” to insert and query data for above
table.
1) Code should use akka actor to execute query
2) There should be client actor to submit the query
3) If same query has been submitted previously executor actor should be able to get
cached data instead of going back to database
*/


/*
 name := "scala-cassandra-example"

//version := "0.1"
scalaVersion := "2.12.4"


/*
scalacOptions ++= Seq("-Xmax-classfile-name", "100")
libraryDependencies ++= Seq(
    "com.datastax.cassandra" % "cassandra-driver-core" % "2.1.6"
  )
*/

libraryDependencies += Seq("com.datastax.cassandra" % "cassandra-driver-core" % "3.3.2")*/

