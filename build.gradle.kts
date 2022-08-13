plugins {
    id("gg.essential.loom")
    id("io.github.juuxel.loom-quiltflower")
    id("dev.architectury.architectury-pack200")
    id("com.github.johnrengelman.shadow")
}

group = "dev.cbyrne"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/repository/maven-public/")
}

@Suppress("UnstableApiUsage")
loom {
    launchConfigs {
        named("client") {
            arg("--mixin", "mixins.bye-bye-narrator.json")
            arg("--tweakClass", "org.spongepowered.asm.launch.MixinTweaker")
        }
    }

    runConfigs {
        named("client") {
            vmArgs.remove("-XstartOnFirstThread")
        }
    }

    mixin {
        add(sourceSets.main.get(), "mixins.bye-bye-narrator.refmap.json")
    }
}

dependencies {
    minecraft("com.mojang:minecraft:1.12.2")
    mappings("de.oceanlabs.mcp:mcp_stable:39-1.12")
    forge("net.minecraftforge:forge:1.12.2-14.23.0.2486")

    implementation("org.spongepowered:mixin:0.8.5")
}

tasks {
    jar {
        manifest {
            attributes(mapOf(
                "MixinConfigs" to "mixins.bye-bye-narrator.json",
                "TweakClass" to "org.spongepowered.asm.launch.MixinTweaker"
            ))
        }
    }

    compileJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
}
