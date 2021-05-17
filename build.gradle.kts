plugins {
  val indraVersion = "1.3.1"
  id("net.kyori.indra") version indraVersion
  id("net.kyori.indra.checkstyle") version indraVersion
  id("net.kyori.indra.license-header") version indraVersion
  id("net.kyori.indra.publishing") version indraVersion
  id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

group = "net.kaoaki"
version = "1.0.0-SNAPSHOT"
description = "Kaoaki Standard Library"

indra {
  javaVersions {
    target.set(8)
    testWith(8, 11, 15)
  }

  github("Kaoaki", "ksl") {
    ci = true
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

nexusPublishing {
  repositories {
    sonatype {
      nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
      snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
    }
  }
}

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {
  checkstyle("ca.stellardrift:stylecheck:0.1")
  compileOnlyApi("org.checkerframework:checker-qual:3.13.0")
  testImplementation("com.google.guava:guava-testlib:30.1.1-jre")
  testImplementation("com.google.truth:truth:1.1.2")
  testImplementation("com.google.truth.extensions:truth-java8-extension:1.1.2")
  testImplementation(platform("org.junit:junit-bom:5.7.2"))
  testImplementation("org.junit.jupiter:junit-jupiter-api")
  testImplementation("org.junit.jupiter:junit-jupiter-params")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
