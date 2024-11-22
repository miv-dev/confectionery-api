
import config.SessionConfig
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.sessions.*
import io.ktor.util.*
import org.koin.ktor.ext.inject

fun Application.authPlugin() {

    val config by inject<SessionConfig>()

    install(Sessions) {
        val secretEncryptKey = hex(config.encryptKey)
        val secretSignKey = hex(config.secretKey)
        cookie<Session>("sessionId", SessionStorageMemory()) {
            transform(SessionTransportTransformerEncrypt(secretEncryptKey, secretSignKey))
        }

    }
    install(Authentication) {

        session<Session>("auth-session") {
            validate { session ->
                session
            }
            challenge {
                call.respond(HttpStatusCode.Unauthorized)
            }
        }
    }
}

