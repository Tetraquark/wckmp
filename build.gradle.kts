buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}
