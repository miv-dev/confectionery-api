import io.ktor.server.application.*

interface ToppingHandler {

    suspend fun search(call: ApplicationCall)

    suspend fun getTypes(call: ApplicationCall)

    suspend fun create(call: ApplicationCall)

    suspend fun update(call: ApplicationCall)

    suspend fun delete(call: ApplicationCall)

}