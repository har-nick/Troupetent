package uk.co.harnick.troupetent.core.db.data.local.adapters

import app.cash.sqldelight.ColumnAdapter
import java.time.Instant

// TODO: Check if ofEpochMilli needs desugaring
object InstantAdapter : ColumnAdapter<Instant, Long> {
    override fun decode(databaseValue: Long): Instant = Instant.ofEpochMilli(databaseValue)

    override fun encode(value: Instant): Long = value.toEpochMilli()
}
