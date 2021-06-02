plugins {
  val indraVersion = "2.0.5"
  id("net.kyori.indra") version indraVersion
  id("net.kyori.indra.checkstyle") version indraVersion
  id("net.kyori.indra.license-header") version indraVersion
  id("net.kyori.indra.publishing") version indraVersion
  id("net.kyori.indra.publishing.sonatype") version indraVersion
}

group = "net.kaoaki"
version = "1.0.0-SNAPSHOT"
description = "Kaoaki Standard Library"

indra {
  javaVersions {
    target(8)
    testWith(8, 11, 15)
  }

  github("Kaoaki", "ksl") {
    ci(true)
  }
  mitLicense()

  configurePublications {
    pom {
      developers {
        developer {
          id.set("kashike")
          timezone.set("America/Vancouver")
        }
      }
    }
  }
}

indraSonatype {
  useAlternateSonatypeOSSHost("s01")
}

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {
  checkstyle("ca.stellardrift:stylecheck:0.1")
  compileOnlyApi("org.checkerframework:checker-qual:3.14.0")
  testImplementation("com.google.guava:guava-testlib:30.1.1-jre")
  testImplementation("com.google.truth:truth:1.1.3")
  testImplementation("com.google.truth.extensions:truth-java8-extension:1.1.3")
  testImplementation(platform("org.junit:junit-bom:5.7.2"))
  testImplementation("org.junit.jupiter:junit-jupiter-api")
  testImplementation("org.junit.jupiter:junit-jupiter-params")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
