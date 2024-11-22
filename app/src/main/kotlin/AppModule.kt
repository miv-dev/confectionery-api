import config.ApplicationConfig
import config.DatabaseConfig
import config.SessionConfig
import di.databaseModule
import org.koin.dsl.module
import di.servicesModule
import di.repositoriesModule
import di.handlersModule

fun appModule(config: ApplicationConfig) = module {
    single<SessionConfig> { config.session }
    single<DatabaseConfig> { config.database }

    includes(
        repositoriesModule,
        servicesModule,
        handlersModule,
        databaseModule(config.database)
    )
}
