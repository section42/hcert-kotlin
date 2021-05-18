plugins {
    kotlin("multiplatform") version "1.5.0"
    kotlin("plugin.serialization") version "1.5.0"
    id("idea")
}

group = "ehn.techiop.hcert"
version = "0.3.0-SNAPSHOT"

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}

repositories {
    mavenLocal()
    jcenter()
    mavenCentral()
}

kotlin {
    targets.all {
        compilations.all {
            kotlinOptions {
                freeCompilerArgs = listOf(
                    "-Xopt-in=kotlin.RequiresOptIn",
                    "-Xopt-in=kotlin.ExperimentalUnsignedTypes",
                    "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi"
                )
            }
        }
    }

    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs = listOf(
                    "-Xjsr305=strict"
                )
            }
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(LEGACY) {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = false
                }
            }
        }
        useCommonJs()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-cbor:1.1.0")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.0")
                implementation("com.augustcellars.cose:cose-java:1.1.0")
                implementation("com.google.zxing:core:3.4.1")
                implementation("com.google.zxing:javase:3.4.1")
                implementation("org.bouncycastle:bcpkix-jdk15to18:1.68")
                implementation("javax.validation:validation-api:2.0.1.Final")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit5"))
                implementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
                implementation("org.junit.jupiter:junit-jupiter-params:5.7.1")
                implementation("org.hamcrest:hamcrest:2.2")
                runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(npm("pako", "2.0.3"))
                implementation(npm("@types/pako", "1.0.1", generateExternals = true))
                implementation(npm("pkijs", "2.1.95"))
                implementation(npm("cose-js", File("${projectDir.absolutePath}/cose-js"), generateExternals = false))
                implementation(npm("crypto-browserify", "3.12.0"))
                implementation(npm("stream-browserify", "3.0.0"))
                implementation(npm("util", "0.12.3"))
                implementation(npm("buffer", "6.0.3"))
                implementation(npm("process", "0.11.10"))
                implementation(npm("cbor", "7.0.5"))
                implementation(npm("node-inspect-extracted", "1.0.7"))
                implementation(npm("fast-sha256", "1.3.0", generateExternals = true))
                implementation(npm("url", "0.11.0"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
