# sconfig
![CI](https://github.com/ekrich/sconfig/workflows/CI/badge.svg)
[![Scala.js](https://www.scala-js.org/assets/badges/scalajs-1.0.0.svg)](https://www.scala-js.org)

Configuration library written in [Scala](https://www.scala-lang.org/) which is a direct translation 
of the original widely used Java library.

[Scala JVM](https://www.scala-lang.org/), [Scala Native](https://scala-native.readthedocs.io/), and [Scala.js](https://www.scala-js.org/)
are supported. Scala JVM is fully supported whereas the other platforms support a subset of the full API.

For motivation and background about this project see the [PR](https://github.com/lightbend/config/pull/600) 
to the original project. The TLDR is the library was ported to Scala to support Scala Native so
[scalafmt](https://scalameta.org/scalafmt/) which uses HOCON configuration could be compiled into
a native application.

Care has been taken to keep the API the same but changes were needed when moving from the Java API.
Using Java is also possible as demonstrated by including the working Java examples.

If you are looking for the original Java API, see
[https://github.com/lightbend/config](https://github.com/lightbend/config).


## Sonatype
[![Maven Central](https://img.shields.io/maven-central/v/org.ekrich/sconfig_2.11.svg)](https://maven-badges.herokuapp.com/maven-central/org.ekrich/sconfig_2.11)

```scala
libraryDependencies += "org.ekrich" %% "sconfig" % "x.y.z"
```

To use in `sbt`, replace `x.y.z` with the version from Maven Central badge above.

For non-JVM projects use `%%%` but please refer to the guide below for **critical** Scala Native and Scala.js usage information. The TLDR is that you must add a `java.time` library dependency to your project. Currently, the only library available is `sjavatime`. Refer to the [`sjavatime` home page](https://github.com/ekrich/sjavatime) for the current version.

[Scala Native and Scala.js](docs/SCALA-NATIVE.md) - A guide to using Scala Native and Scala.js.

All available versions can be seen at the [Maven Repository](https://mvnrepository.com/artifact/org.ekrich/sconfig).

## Cross Build Versions
[![Scala.js](https://www.scala-js.org/assets/badges/scalajs-1.0.0.svg)](https://www.scala-js.org)

| Scala Version          | JVM | Scala.js (1.x)        | Native (0.4.x) |
| ---------------------- | :-: | :-------------------: | :------------: |
| 2.11.x                 | ✅  |          ✅           |       ✅       |
| 2.12.x                 | ✅  |          ✅           |       ✅       |
| 2.13.x                 | ✅  |          ✅           |       ✅       |
| 3.0.0-RC2              | ✅  |          ✅           |      n/a       |

## Usage and Help
[![Scaladoc](https://www.javadoc.io/badge/org.ekrich/sconfig_2.11.svg?label=scaladoc)](https://www.javadoc.io/doc/org.ekrich/sconfig_2.11)
[![Join chat https://gitter.im/ekrich/sconfig](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/ekrich/sconfig?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Please refer to the original library documentation [here](https://github.com/lightbend/config).
This is to reduce the maintenance burden of this library.

The intent is to keep the library in sync with the original but each PR needs to be be ported
to maintain feature parity. The documentation could contain features that are not yet implemented
in this library.

For specific changes, refer to the releases below.

## Versions

Release [1.4.2](https://github.com/ekrich/sconfig/releases/tag/v1.4.2) - (2021-04-01)<br/>
Release [1.4.1](https://github.com/ekrich/sconfig/releases/tag/v1.4.1) - (2021-02-24)<br/>
Release [1.4.0](https://github.com/ekrich/sconfig/releases/tag/v1.4.0) - (2021-01-26)<br/>
Release [1.3.6](https://github.com/ekrich/sconfig/releases/tag/v1.3.6) - (2020-12-21)<br/>
Release [1.3.5](https://github.com/ekrich/sconfig/releases/tag/v1.3.5) - (2020-11-24)<br/>
Release [1.3.4](https://github.com/ekrich/sconfig/releases/tag/v1.3.4) - (2020-11-03)<br/>
Release [1.3.3](https://github.com/ekrich/sconfig/releases/tag/v1.3.3) - (2020-09-14)<br/>
Release [1.3.2](https://github.com/ekrich/sconfig/releases/tag/v1.3.2) - (2020-09-01)<br/>
Release [1.3.1](https://github.com/ekrich/sconfig/releases/tag/v1.3.1) - (2020-07-24)<br/>
Release [1.3.0](https://github.com/ekrich/sconfig/releases/tag/v1.3.0) - (2020-05-01)<br/>
Release [1.2.2](https://github.com/ekrich/sconfig/releases/tag/v1.2.2) - (2020-04-28)<br/>
Release [1.2.1](https://github.com/ekrich/sconfig/releases/tag/v1.2.1) - (2020-02-18)<br/>
Release [1.1.3](https://github.com/ekrich/sconfig/releases/tag/v1.1.3) - (2019-12-27)<br/>
Release [1.0.0](https://github.com/ekrich/sconfig/releases/tag/v1.0.0) - (2019-08-05)<br/>
Release [0.9.2](https://github.com/ekrich/sconfig/releases/tag/v0.9.2) - (2019-06-10)<br/>
Release [0.9.1](https://github.com/ekrich/sconfig/releases/tag/v0.9.1) - (2019-05-22)<br/>
Release [0.9.0](https://github.com/ekrich/sconfig/releases/tag/v0.9.0) - (2019-05-21)<br/>
Release [0.8.0](https://github.com/ekrich/sconfig/releases/tag/v0.8.0) - (2019-04-23)<br/>
Release [0.7.6](https://github.com/ekrich/sconfig/releases/tag/v0.7.6) - (2019-04-10)<br/>
Release [0.7.5](https://github.com/ekrich/sconfig/releases/tag/v0.7.5) - (2019-04-05)<br/>
Release [0.7.0](https://github.com/ekrich/sconfig/releases/tag/v0.7.0) - (2018-12-14)
