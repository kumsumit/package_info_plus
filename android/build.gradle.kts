import org.jetbrains.kotlin.gradle.dsl.JvmTarget
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android") version "2.3.21"
}
group = 'dev.fluttercommunity.plus.packageinfo'
version = '1.0-SNAPSHOT'

repositories {
        google()
        mavenCentral()
    }

android {
    compileSdk = 37

    namespace = 'dev.fluttercommunity.plus.packageinfo'

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    defaultConfig {
        minSdk = 24
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            all {
                it.useJUnitPlatform()
                it.outputs.upToDateWhen { false }
                it.testLogging {
                    events("passed", "skipped", "failed", "standardOut", "standardError")
                    showStandardStreams = true
                }
            }
        }
    }
}

dependencies {
        implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    }