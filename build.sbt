lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "play-seed2",
    organization := "com.github.gcnyin",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Seq(
      guice,
      evolutions,
      jdbc,
      "com.typesafe.play" %% "play-slick" % "5.0.2",
      "org.postgresql" % "postgresql" % "42.5.0"
    )
  )
