package uk.co.harnick.troupetent.core.db.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import uk.co.harnick.troupetent.LocalStorage
import java.util.Properties

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        // TODO: Make persistent
        val driver = JdbcSqliteDriver(
            url = JdbcSqliteDriver.IN_MEMORY,
            properties = Properties().apply { put("foreign_keys", "true") }
        )
        LocalStorage.Schema.create(driver)
        return driver
    }
}
