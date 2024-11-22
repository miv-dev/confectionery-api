import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import config.DatabaseConfig
import org.jetbrains.exposed.sql.Database

class DatabaseManager(
    private val config: DatabaseConfig
) {
    fun connect() {
        val config = HikariConfig().also { hikari ->
            hikari.driverClassName = DRIVER_CLASS_NAME
            hikari.transactionIsolation = TRANSACTION_ISOLATION
            hikari.jdbcUrl = config.url
            hikari.username = config.username
            hikari.password = config.password
        }
        Database.Companion.connect(HikariDataSource(config))

    }

    companion object {
        private const val DRIVER_CLASS_NAME = "org.postgresql.Driver"
        private const val TRANSACTION_ISOLATION = "TRANSACTION_REPEATABLE_READ"
    }

}