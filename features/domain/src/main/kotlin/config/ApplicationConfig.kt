package config

data class ApplicationConfig(
    val database: DatabaseConfig,
    val session: SessionConfig
)
