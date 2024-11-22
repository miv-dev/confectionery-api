import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*
import routes.authRouting

fun Application.routingPlugin() {
    routing {
        authenticate("auth-session") {

        }

        authRouting()

        swaggerUI(path = "docs", swaggerFile = "openapi/doc.yaml"){
            version = "4.15.5"
        }
    }
}