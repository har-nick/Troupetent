package uk.co.harnick.troupetent.core.db.data.local.adapters

import app.cash.sqldelight.ColumnAdapter

object EnumToStringAdapter {
    inline operator fun <reified T : Enum<T>> invoke(): ColumnAdapter<T, String> {
        return object : ColumnAdapter<T, String> {
            override fun decode(databaseValue: String): T =
                T::class.java.enumConstants!!.find { it.name == databaseValue }!!

            override fun encode(value: T): String = value.name
        }
    }
}
