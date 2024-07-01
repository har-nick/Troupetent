package uk.co.harnick.troupetent.core.db.data.local.adapters

import app.cash.sqldelight.ColumnAdapter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object AnyToStringAdapter {
    inline operator fun <reified T : Any> invoke(): ColumnAdapter<T, String> {
        return object : ColumnAdapter<T, String> {
            override fun decode(databaseValue: String): T = Json.decodeFromString(databaseValue)
            override fun encode(value: T): String = Json.encodeToString(value)
        }
    }
}
