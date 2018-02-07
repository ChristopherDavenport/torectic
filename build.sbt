lazy val torectic = project.in(file("."))
    .settings(commonSettings)
    .settings(
      name := "torectic"
    )

/***********************************************************************\
                      Boilerplate below these lines
\***********************************************************************/




lazy val commonSettings = Seq(
  organization := "io.chrisdavenport",
  licenses += ("MIT", url("https://opensource.org/licenses/MIT")),

  scalaVersion := "2.12.4",
  crossScalaVersions := Seq(scalaVersion.value, "2.11.12"),

  addCompilerPlugin("org.spire-math" % "kind-projector" % "0.9.4" cross CrossVersion.binary),

  libraryDependencies ++= Seq(
    "org.specs2"                  %% "specs2-core"                % "4.0.1"       % Test,
    "org.specs2"                  %% "specs2-scalacheck"          % "4.0.1"       % Test,
    "org.typelevel"               %% "discipline"                 % "0.8"         % Test,
    "com.github.alexarchambault"  %% "scalacheck-shapeless_1.13"  % "1.1.6"       % Test
  )
)
