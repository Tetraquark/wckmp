import org.jetbrains.kotlin.cli.jvm.main

plugins {
    kotlin("multiplatform")
}

group = "ru.tetraquark"
version = "1.0.0"

kotlin {
    val nativeEntryPoint = "ru.tetraquark.wckmp.main"

    jvm()
    macosX64 {
        binaries {
            executable {
                entryPoint = nativeEntryPoint
            }
        }
    }
    linuxX64 {
        binaries {
            executable {
                entryPoint = nativeEntryPoint
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
            }
        }
        val macosX64Main by getting {
            dependencies {}
        }
        val linuxX64Main by getting {
            dependencies {}
        }
    }
}
