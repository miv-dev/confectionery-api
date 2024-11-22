plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.serialization)
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(libs.ktor.server.core)
    implementation(libs.ktor.serialization.kotlinx.json)
}