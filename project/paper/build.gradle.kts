plugins {
    id("java")
    id("com.gradleup.shadow")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.bundles.kotlin.common)
    compileOnly(libs.bundles.bukkit.api)

    implementation(project(":project:common"))
}

tasks.processResources {
    val props = mapOf("version" to version, "name" to rootProject.name)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") { expand(props) }
}