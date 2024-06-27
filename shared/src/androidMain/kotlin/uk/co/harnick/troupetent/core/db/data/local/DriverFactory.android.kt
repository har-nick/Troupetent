package uk.co.harnick.troupetent.core.db.data.local

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import uk.co.harnick.troupetent.LocalStorage

actual class DriverFactory(private val appContext: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = LocalStorage.Schema,
            context = appContext,
            name = "localstorage.db",
            callback = object : AndroidSqliteDriver.Callback(LocalStorage.Schema) {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    db.setForeignKeyConstraintsEnabled(true)
                }
            }
        )
    }
}
