plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":features:services"))
    implementation(project(":features:utils"))
    implementation(project(":features:domain"))
    implementation(project(":plugins:auth"))

    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.session)

    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
}