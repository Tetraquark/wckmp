import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm")
}

group = "ru.tetraquark.wckmp.jvm"
version = "1.0.0"

application {
    mainClassName = "ru.tetraquark.wckmp.jvm.MainKt"
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":wckmp"))
}
