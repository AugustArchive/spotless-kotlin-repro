plugins {
    id("com.diffplug.spotless") version "6.16.0"
    kotlin("jvm") version "1.8.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

spotless {
    encoding("UTF-8")
    kotlin {
        licenseHeaderFile(file("$projectDir/assets/LICENSE"))
        endWithNewline()
        encoding("UTF-8")
        ktlint().apply {
            setUseExperimental(true)
            setEditorConfigPath(file("$projectDir/.editorconfig"))
        }
    }

    kotlinGradle {
        licenseHeaderFile(file("$projectDir/assets/LICENSE"), "(package |@file|import |pluginManagement |plugins )")
        endWithNewline()
        encoding("UTF-8")
        ktlint().apply {
            setUseExperimental(true)
            setEditorConfigPath(file("$projectDir/.editorconfig"))
        }
    }
}
