package uk.co.harnick.troupetent.core.db.data.local.adapters

import app.cash.sqldelight.ColumnAdapter
import java.time.ZonedDateTime

object ZonedDateTimeAdapter : ColumnAdapter<ZonedDateTime, String> {
    override fun decode(databaseValue: String): ZonedDateTime = ZonedDateTime.parse(databaseValue)
    override fun encode(value: ZonedDateTime): String = value.toString()
}
