import sbt.Keys._

val core = Project("enum-utils", file("core"))
  .enablePlugins(OssLibPlugin)
  .settings(organization := "com.thenewmotion",
    name := "enum-utils",
    libraryDependencies ++= Seq(
      "org.specs2" %% "specs2-core" % "3.9.5" % "test"
    )
  )

val sprayJson = Project("enum-utils-spray-json", file("spray-json"))
  .enablePlugins(OssLibPlugin)
  .dependsOn(core)
  .settings(
    organization := "com.thenewmotion",
    name := "enum-utils-spray-json",
    libraryDependencies ++= Seq(
      "io.spray"    %% "spray-json"   % "1.3.3",
      "org.specs2"  %% "specs2-core"  % "3.9.5" % "test"
    )
  )


val parent = Project("enum-utils-parent", file("."))
  .aggregate(core, sprayJson)
  .enablePlugins(LibPlugin)
  .settings(publish := {})
