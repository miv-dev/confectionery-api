package impl

import ToppingHandler
import ToppingService
import dto.ToppingRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.util.*
import mapper.toDTO
import java.time.LocalDate

class ToppingHandlerImpl(
    private val service: ToppingService
) : ToppingHandler {
    override suspend fun search(call: ApplicationCall) {
        val typeID = call.request.queryParameters["type-id"]?.toInt()
        val shelfLife = call.request.queryParameters["shelf-life"]?.let { LocalDate.parse(it) }

        val list = service.search(typeID, shelfLife).map { it.toDTO() }

        call.respond(list)
    }

    override suspend fun getTypes(call: ApplicationCall) {
        val types = service.getTypes().map { it.toDTO() }
        call.respond(types)
    }

    override suspend fun create(call: ApplicationCall) {
        val data = call.receive<ToppingRequest>()
        service.create(
            data.article,
            data.typeId,
            data.name,
            data.quantity,
            data.unit,
            data.purchasePrice,
            data.supplierId,
            data.deliveryDuration,
            data.shelfLife
        ).also {
            call.respond(it.toDTO())
        }
    }

    override suspend fun update(call: ApplicationCall) {
        val id = call.parameters.getOrFail<Int>("id")
        val data = call.receive<ToppingRequest>()
        service.update(
            id,
            data.article,
            data.typeId,
            data.name,
            data.quantity,
            data.unit,
            data.purchasePrice,
            data.supplierId,
            data.deliveryDuration,
            data.shelfLife
        ).also {
            call.respond(it.toDTO())
        }
    }

    override suspend fun delete(call: ApplicationCall) {
        val id = call.parameters.getOrFail<Int>("id")
        service.delete(id)
        call.respond(HttpStatusCode.OK)
    }
}