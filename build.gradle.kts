import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.4.10"
    id("org.jetbrains.compose") version "1.2.2"
}

val ktor_version: String by project

group = "com.techlads"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {

                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.cio)
                implementation(libs.ktor.client.serialization)

                implementation(libs.ktor.client.negotiation)
                implementation(libs.ktor.client.serialization.kotlinx)

                implementation(libs.ktor.client.logging)

                implementation(libs.jetbrains.serialization.kotlinx)
                implementation(libs.jetbrains.kotlin.stdlib)
                implementation(libs.jetbrains.kotlin.coroutines)
                implementation(libs.jetbrains.kotlin.coroutines.swing)
            }
        }
        val jvmMain by getting {
            dependencies {
                dependsOn(commonMain)
                implementation(compose.desktop.currentOs)
                implementation(compose.material)
                implementation(compose.materialIconsExtended)
                // Decompose : Decompose
                implementation(libs.decompose)
                implementation(libs.decompose.extensions)
                // Icons libraries
                implementation(libs.devsrsouza.compose.jetbrains.simple.icons)
                implementation(libs.devsrsouza.compose.jetbrains.font.awesome)
                implementation(libs.devsrsouza.compose.jetbrains.tabler.icon)
                implementation(libs.devsrsouza.compose.jetbrains.line.awesome)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "mainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "WorkSpacePro"
            packageVersion = "1.0.1"
        }
    }
}
