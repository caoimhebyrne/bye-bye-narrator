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
        id("gg.essential.loom") version "1.6.16"
        id("dev.architectury.architectury-pack200") version "0.1.3"
    }
}
