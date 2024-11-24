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
    implementation(project(":plugins:auth"))

    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.ktor)
    implementation(libs.koin.core)

    implementation ("io.github.smiley4:ktor-swagger-ui:3.6.0")
    implementation("io.github.smiley4:schema-kenerator-swagger:1.6.0")
    implementation("io.github.smiley4:schema-kenerator-core:1.6.0")
    implementation("io.github.smiley4:schema-kenerator-serialization:1.6.0")


    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.auth)

    implementation(libs.ktor.serialization.kotlinx.json)
}