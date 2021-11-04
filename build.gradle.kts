import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.compose") version "1.0.0-beta5"
}

group = "de.dbaelz.stellar"
version = "1.0"

repositories {
    google()
    jcenter()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)

    testImplementation(compose("org.jetbrains.compose.ui:ui-test-junit4"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "16"
}

compose.desktop {
    application {
        mainClass = "de.dbaelz.stellar.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Stellar Presentation"
            packageVersion = "1.0.0"

            // TODO: Switch with Stellar Presentation icon
            linux {
                iconFile.set(project.file("icons/compose-desktop-logo.png"))
            }

            // TODO: Switch with Stellar Presentation icon
            windows {
                iconFile.set(project.file("icons/compose-desktop-logo.ico"))
            }
        }
    }
}