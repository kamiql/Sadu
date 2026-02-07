plugins {
    id("java")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.bundles.kotlin.common)
    compileOnly(libs.bundles.velocity.api)

    implementation(project(":project:common"))
}