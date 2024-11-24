package routes

import SupplierHandler
import dto.SupplierDTO
import io.github.smiley4.ktorswaggerui.dsl.routing.get
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.supplierRouting() {
    val handler by inject<SupplierHandler>()

    route("/suppliers") {
        get({
            description = "List all suppliers"
            response {
                HttpStatusCode.OK to {
                    description = "List of suppliers"
                    body<List<SupplierDTO>>()
                }
            }
        }) {
            handler.list(call)
        }
    }
}