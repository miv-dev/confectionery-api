
import io.ktor.server.application.*

interface AuthHandler {
    suspend fun login(call: ApplicationCall)

    suspend fun register(call: ApplicationCall)
}