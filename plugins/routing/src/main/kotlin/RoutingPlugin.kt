import io.github.smiley4.ktorswaggerui.SwaggerUI
import io.github.smiley4.ktorswaggerui.routing.openApiSpec
import io.github.smiley4.ktorswaggerui.routing.swaggerUI
import io.github.smiley4.schemakenerator.serialization.processKotlinxSerialization
import io.github.smiley4.schemakenerator.swagger.compileReferencingRoot
import io.github.smiley4.schemakenerator.swagger.data.TitleType
import io.github.smiley4.schemakenerator.swagger.generateSwaggerSchema
import io.github.smiley4.schemakenerator.swagger.handleCoreAnnotations
import io.github.smiley4.schemakenerator.swagger.withTitle
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*
import routes.authRouting
import routes.supplierRouting
import routes.toolRouting

fun Application.routingPlugin() {
    install(SwaggerUI) {
        schemas {
            generator = { type ->
                type
                    .processKotlinxSerialization()
                    .generateSwaggerSchema()
                    .withTitle(TitleType.SIMPLE)
                    .handleCoreAnnotations()
                    .compileReferencingRoot()
            }
        }
        info {
            title = "Кондитерская API"
            version = "latest"
            description = "Example API for testing and demonstration purposes."
        }
        server {
            url = "http://localhost:8080"
            description = "Development Server"
        }
        server {
            url = "http://176.124.213.100:8080"
            description = "Production Server"
        }
    }


    routing {
//        authenticate("auth-session") {
            toolRouting()
            supplierRouting()
//        }

        authRouting()
        route("api.json") {
            openApiSpec()
        }

        route("/docs") {
            swaggerUI("/api.json")
        }
    }
}