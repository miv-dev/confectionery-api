plugins {
    alias(libs.plugins.kotlin.jvm)
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":features:db"))
    implementation(project(":features:domain"))


    implementation(libs.exposed.core)
    implementation(libs.exposed.dao)

    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.ktor)

}