package extensions

import io.ktor.server.application.*
import java.io.File

fun Application.getPropertyFromFile(property: String): String {
    val path = stringProperty("$property.file")
    val text = if (path != null) {
        if (!File(path).exists()) throw RuntimeException("File does not exist: $path")
        File(path).readText().trim()
    } else {
        stringProperty("$property.text") ?: throw Exception("Property $property not found")
    }


    return text
}