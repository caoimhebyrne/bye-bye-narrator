plugins {
    id("gg.essential.loom")
    id("dev.architectury.architectury-pack200")
}

group = "dev.caoimhe"
version = "1.0.1"

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/repository/maven-public/")
}

loom {
    runConfigs {
        named("client") {
            vmArgs.remove("-XstartOnFirstThread")
            vmArgs.add("fml.coreMods.load=dev.caoimhe.byebyenarrator.BBNLoadingPlugin")
        }
    }
}

dependencies {
    minecraft("com.mojang:minecraft:1.12.2")
    mappings("de.oceanlabs.mcp:mcp_stable:39-1.12")
    forge("net.minecraftforge:forge:1.12.2-14.23.0.2486")
}

tasks {
    jar {
        manifest {
            attributes(mapOf(
                "FMLCorePlugin" to "dev.caoimhe.byebyenarrator.BBNLoadingPlugin",
                "FMLCorePluginContainsFMLMod" to "true",
            ))
        }
    }

    compileJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
}
