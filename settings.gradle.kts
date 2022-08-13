rootProject.name = "bye-bye-narrator"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://repo.essential.gg/repository/maven-public/")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net/")
    }

    plugins {
        id("com.github.johnrengelman.shadow") version "7.0.0"
        id("gg.essential.loom") version "0.10.0.3"
        id("dev.architectury.architectury-pack200") version "0.1.3"
        id("io.github.juuxel.loom-quiltflower") version "1.7.3"
    }
}
