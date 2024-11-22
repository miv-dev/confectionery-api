import config.ApplicationConfig
import config.DatabaseConfig
import config.SessionConfig
import extensions.getPropertyFromFile
import extensions.stringProperty
import io.ktor.server.application.*

fun Application.parseConfig(): ApplicationConfig {
    val db = DatabaseConfig(
        stringProperty("database.url") ?: throw Exception("Database url is required"),
        getPropertyFromFile("database.username"),
        getPropertyFromFile("database.password"),
    )
    val session = SessionConfig(
        getPropertyFromFile("session.secret"),
        getPropertyFromFile("session.encrypt"),
    )
    return ApplicationConfig(
        db,
        session,
    )
}