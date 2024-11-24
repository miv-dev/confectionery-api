import io.github.smiley4.ktorswaggerui.SwaggerUI
import io.github.smiley4.ktorswaggerui.routing.openApiSpec
import io.github.smiley4.ktorswaggerui.routing.swaggerUI
import io.github.smiley4.schemakenerator.core.connectSubTypes
import io.github.smiley4.schemakenerator.core.data.AnnotationData
import io.github.smiley4.schemakenerator.core.data.ObjectTypeData
import io.github.smiley4.schemakenerator.core.data.PrimitiveTypeData
import io.github.smiley4.schemakenerator.core.data.TypeId
import io.github.smiley4.schemakenerator.reflection.processReflection
import io.github.smiley4.schemakenerator.serialization.addJsonClassDiscriminatorProperty
import io.github.smiley4.schemakenerator.serialization.processKotlinxSerialization
import io.github.smiley4.schemakenerator.swagger.*
import io.github.smiley4.schemakenerator.swagger.data.TitleType
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*
import io.swagger.v3.oas.models.media.Schema
import kotlinx.serialization.Serializable
import routes.authRouting
import routes.supplierRouting
import routes.toolRouting
import routes.toppingRouting
import java.time.LocalDate
import java.util.UUID

fun Application.routingPlugin() {
    install(SwaggerUI) {
        schemas {

            generator = { type ->
                type
                    .processKotlinxSerialization()
                    .generateSwaggerSchema()
                    .withTitle(TitleType.SIMPLE)
                    .compileReferencingRoot()

            }
            overwrite<LocalDate>(Schema<Any>().also {
                it.format = "date"
                it.type = "string"
                it.description = "Date in ISO 8601 format (YYYY-MM-DD), e.g. 2021-12-31"
            })
            overwrite<UUID>(Schema<Any>().also {
                it.format = "uuid"
                it.type = "string"
            })
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
        toppingRouting()
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