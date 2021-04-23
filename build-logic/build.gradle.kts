plugins {
  id("org.gradle.kotlin.kotlin-dsl").apply {
    version(org.gradle.kotlin.dsl.support.expectedKotlinDslPluginsVersion)
  }
}

repositories {
  gradlePluginPortal()
}

dependencies {
  with(project.property("indraVersion") as String) {
    implementation("net.kyori", "indra-common", this)
    implementation("net.kyori", "indra-git", this)
    implementation("net.kyori", "indra-publishing-sonatype", this)
  }
}
