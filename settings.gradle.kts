enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.github.com/har-nick/bandkit") {
            credentials {
                username = System.getenv("GH_USERNAME")
                password = System.getenv("GH_TOKEN_PACKAGE_READING")
            }
        }
    }
}

rootProject.name = "Troupetent"
include(":shared")
includeBuild("../BandKit")
