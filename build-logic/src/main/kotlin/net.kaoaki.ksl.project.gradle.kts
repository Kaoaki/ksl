plugins {
  id("net.kaoaki.ksl.common")
  id("net.kyori.indra")
  id("net.kyori.indra.checkstyle")
  id("net.kyori.indra.license-header")
}

repositories {
  mavenCentral()
}

dependencies {
  checkstyle("ca.stellardrift", "stylecheck", "0.1")
}
