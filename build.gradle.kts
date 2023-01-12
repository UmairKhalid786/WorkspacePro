import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.4.10"
    id("org.jetbrains.compose")
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
            }
        }
        val jvmMain by getting {
            dependencies {
                dependsOn(commonMain)
                implementation(compose.desktop.currentOs)
                implementation(compose.material)
                // Icons libraries
                implementation(libs.devsrsouza.compose.jetbrains.simple.icons)
                implementation(libs.devsrsouza.compose.jetbrains.font.awesome)
                implementation(libs.devsrsouza.compose.jetbrains.tabler.icon)
                implementation(libs.devsrsouza.compose.jetbrains.line.awesome)
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "WorkSpacePro"
            packageVersion = "1.0.1"
        }
    }
}
