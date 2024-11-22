plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.serialization)
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(project(":features:domain"))
    implementation(project(":features:utils"))
    implementation(project(":features:handlers"))

    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.ktor)
    implementation(libs.koin.core)


    implementation(libs.ktor.server.swagger)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.auth)

    implementation(libs.ktor.serialization.kotlinx.json)
}