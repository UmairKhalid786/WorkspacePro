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

                implementation("io.ktor:ktor-client-core:${ktor_version}")
                implementation("io.ktor:ktor-client-cio:${ktor_version}")
                implementation("io.ktor:ktor-client-serialization:${ktor_version}")

                implementation("io.ktor:ktor-client-content-negotiation:${ktor_version}")
                implementation("io.ktor:ktor-serialization-kotlinx-json:${ktor_version}")

                implementation("io.ktor:ktor-client-logging:${ktor_version}")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
                implementation("org.jetbrains.kotlin:kotlin-stdlib:1.2.30")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
            }
        }
        val jvmMain by getting {
            dependencies {
                dependsOn(commonMain)
                implementation(compose.desktop.currentOs)
                implementation(compose.material)
                implementation("br.com.devsrsouza.compose.icons.jetbrains:simple-icons:1.0.0")
                implementation("br.com.devsrsouza.compose.icons.jetbrains:font-awesome:1.0.0")
                implementation("br.com.devsrsouza.compose.icons.jetbrains:tabler-icons:1.0.0")
                implementation("br.com.devsrsouza.compose.icons.jetbrains:line-awesome:1.0.0")
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
            packageVersion = "1.0.0"
        }
    }
}
