
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor.server)
    alias(libs.plugins.serialization)
}

version = "0.0.3"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":plugins:auth"))
    implementation(project(":plugins:routing"))

    implementation(project(":features:domain"))
    implementation(project(":features:utils"))
    implementation(project(":features:repositories"))
    implementation(project(":features:handlers"))
    implementation(project(":features:services"))
    implementation(project(":features:db"))

    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.config.yaml)
    implementation(libs.ktor.server.swagger)

    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.ktor)

    implementation(libs.logback.classic)
    implementation("io.insert-koin:koin-logger-slf4j:3.5.6")
}
