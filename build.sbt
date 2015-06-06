name := """radiance-ingest"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.4.0-1",
  "org.webjars" % "jquery" % "2.1.4",
  "org.webjars" % "bootstrap" % "3.1.1-2",
  "org.webjars" % "angularjs" % "2.0.0-alpha.19",
  "org.webjars" % "angular-material" % "0.9.7",
  "org.webjars.bower" % "angular-material-icons" % "0.4.0",
  "org.webjars.bower" % "angular-animate" % "1.4.0-rc.2",
  "org.webjars.npm" % "angular-aria" % "1.4.0",
  "org.webjars" % "d3js" % "3.5.5-1",
  "org.webjars" % "font-awesome" % "4.3.0-2",
  "org.webjars.bower" % "font-awesome-animation" % "0.0.6"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

