import io.ktor.server.application.*

interface ToolHandler {
    suspend fun list(call: ApplicationCall)

    suspend fun allTypes(call: ApplicationCall)

    suspend fun create(call: ApplicationCall)
}