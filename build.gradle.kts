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
}
