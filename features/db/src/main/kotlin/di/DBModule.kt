package di

import DatabaseManager
import config.DatabaseConfig
import org.koin.dsl.module

fun databaseModule(config: DatabaseConfig) = module {
    single { DatabaseManager(config) }
}
