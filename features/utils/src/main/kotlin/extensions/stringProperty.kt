package extensions

import io.ktor.server.application.*

fun Application.stringProperty(path: String): String? =
    this.environment.config.propertyOrNull(path)?.getString()