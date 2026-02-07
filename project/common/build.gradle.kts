plugins {
    id("java")
}

repositories {
    maven(url = "https://central.sonatype.com/repository/maven-snapshots/")
}

dependencies {
    compileOnly(libs.bundles.kotlin.common)

    compileOnly("net.kyori:adventure-api:4.26.1")
}