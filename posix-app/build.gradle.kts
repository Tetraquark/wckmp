plugins {
    kotlin("multiplatform")
}

group = "ru.tetraquark"
version = "1.0.0"

kotlin {
    val nativeEntryPoint = "ru.tetraquark.wckmp.posix.main"
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
        val macosX64Main by getting {
            dependencies {
                implementation(project(":wckmp"))
            }
        }
        val linuxX64Main by getting {
            dependencies {
                implementation(project(":wckmp"))
            }
        }
    }
}
