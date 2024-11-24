package routes

import ToppingHandler
import dto.ToppingRequest
import dto.ToppingDTO
import dto.ToppingTypeDTO
import io.github.smiley4.ktorswaggerui.dsl.routing.delete
import io.github.smiley4.ktorswaggerui.dsl.routing.get
import io.github.smiley4.ktorswaggerui.dsl.routing.post
import io.github.smiley4.ktorswaggerui.dsl.routing.put
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.time.LocalDate

fun Route.toppingRouting() {
    val handler by inject<ToppingHandler>()

    route("/toppings") {
        get("/types", {
            description = "List all topping types"

            response {
                HttpStatusCode.OK to {
                    description = "Topping types"
                    body<List<ToppingTypeDTO>>()
                }
            }
        }) {
            handler.getTypes(call)
        }

        get({
            description = "List all toppings"
            request {
                queryParameter<Int>("type-id"){
                    required = false
                    description = "Type ID"
                }
                queryParameter<LocalDate>("shelf-life"){
                    required = false
                    description = "Shelf life, e.g. 2021-12-31"
                }
            }
            response {
                HttpStatusCode.OK to {
                    description = "Toppings"
                    body<List<ToppingDTO>>()
                }
            }
        }) {
            handler.search(call)
        }

        post({
            description = "Create a new topping"
            request {
                body<ToppingRequest> {
                    description = "Topping data"
                }
            }
            response {
                HttpStatusCode.OK to {
                    description = "Created topping"
                    body<ToppingDTO> {
                        description = "Topping data"
                    }
                }
            }
        }) {
            handler.create(call)
        }

        put("/{id}", {
            description = "Update a topping"
            request {
                pathParameter<Int>("id") {
                    description = "Topping ID"
                }
                body<ToppingRequest> {
                    description = "Topping data"
                }
            }
            response {
                HttpStatusCode.OK to {
                    description = "Updated topping"
                    body<ToppingDTO> {
                        description = "Topping data"
                    }
                }
            }
        }) {
            handler.update(context)
        }

        delete("/{id}", {
            description = "Delete a topping"
            request {
                pathParameter<Int>("id") {
                    description = "Topping ID"
                }
            }
            response {
                HttpStatusCode.OK to {
                    description = "Deleted topping"
                }
            }
        }) {
            handler.delete(context)
        }
    }
}