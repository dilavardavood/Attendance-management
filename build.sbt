name := """attendance-management"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.12"


libraryDependencies ++= Seq(
  guice,
  jdbc,
  "org.projectlombok" % "lombok" % "1.18.22" % "provided",
  "mysql" % "mysql-connector-java" % "8.0.31",
  javaJdbc
)


resolvers ++= Seq(
  "Secured Central Repository" at "https://repo1.maven.org/maven2",
  "Typesafe Repo" at "https://repo.typesafe.com/typesafe/releases/"
)
libraryDependencies += filters
