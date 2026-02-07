import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.3.0" apply false
    id("com.gradleup.shadow") version "9.3.0" apply false
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java")
    apply(plugin = "com.gradleup.shadow")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
        withSourcesJar()
        withJavadocJar()
    }

    tasks.named<ShadowJar>("shadowJar") {
        archiveBaseName.set("${rootProject.name}-${project.name}")
        archiveVersion.set(rootProject.version.toString())
        archiveClassifier.set("")
    }
}

allprojects {
    group = "dev.kamiql"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()

        maven("https://jitpack.io")
    }
}