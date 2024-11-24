plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":features:repositories"))
    implementation(project(":features:domain"))
    implementation(project(":features:utils"))


    implementation(libs.ktor.server.core)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
}