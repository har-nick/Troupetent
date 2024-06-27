import org.jetbrains.compose.desktop.application.dsl.TargetFormat.AppImage
import org.jetbrains.compose.desktop.application.dsl.TargetFormat.Exe

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.sqldelight)
}

kotlin {
    applyDefaultHierarchyTemplate()
    jvmToolchain(libs.versions.jdk.get().toInt())

    jvm("desktop")

    androidTarget {
        dependencies {
            coreLibraryDesugaring(libs.android.desugaring)
            debugImplementation(libs.bundles.debug)
        }
    }

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(libs.bundles.compose.multiplatform)

            implementation(libs.bundles.ktor)
            implementation(libs.bundles.material.you.utils)
            implementation(libs.bundles.sqldelight.utils)
            implementation(libs.bundles.voyager)

            implementation(libs.bandkit)
            implementation(libs.coroutines.core)
            implementation(libs.kamel)
            implementation(libs.reflection)
            implementation(libs.systemutils)
            implementation(libs.windowsize)
        }

        androidMain.dependencies {
            implementation(libs.bundles.media3)

            implementation(libs.androidx.core)
            implementation(libs.androidx.splashscreen)
            implementation(libs.compose.activity)
            implementation(libs.coroutines.android)
            implementation(libs.sqldelight.driver.android)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.coroutines.jvm)
            implementation(libs.coroutines.swing)
            implementation(libs.sqldelight.driver.jvm)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "uk.co.harnick.troupetent"
    compileSdk = libs.versions.android.sdk.compile.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    buildFeatures.compose = true

    defaultConfig {
        applicationId = "uk.co.harnick.troupetent"
        minSdk = libs.versions.android.sdk.min.get().toInt()
        targetSdk = libs.versions.android.sdk.compile.get().toInt()
        versionCode = 1
        versionName = "0.1 - Alpha"
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,versions/9/previous-compilation-data.bin}"
        }
    }
}
composeCompiler {
    enableNonSkippingGroupOptimization = true
    enableStrongSkippingMode = true
}

compose {
    desktop.application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(AppImage, Exe)
        }
    }
}

sqldelight {
    databases {
        create("LocalStorage") {
            packageName.set("uk.co.harnick.troupetent")
        }
    }
}
