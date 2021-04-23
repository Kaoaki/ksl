plugins {
  id("net.kyori.indra.publishing")
}

indra {
  javaVersions {
    target(8)
    testWith(8, 11, 16)
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
