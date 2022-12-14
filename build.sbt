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
      "org.postgresql" % "postgresql" % "42.5.0",
      "eu.timepit" %% "refined" % "0.10.1",
      "be.venneborg" %% "play28-refined" % "0.6.0",
      "org.julienrf" %% "play-json-derived-codecs" % "10.1.0"
    )
  )
