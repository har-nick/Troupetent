package uk.co.harnick.troupetent.core.settings.data.local.adapters

import app.cash.sqldelight.ColumnAdapter
import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.util.toBool
import uk.co.harnick.troupetent.core.util.toLong

object BooleanSettingAdapter {
    inline operator fun <reified T : Setting<Boolean>> invoke(): ColumnAdapter<T, Long> {
        return object : ColumnAdapter<T, Long> {
            override fun decode(databaseValue: Long): T =
                T::class.java
                    .getConstructor(Boolean::class.java)
                    .newInstance(databaseValue.toBool())

            override fun encode(value: T): Long = value.value.toLong()
        }
    }
}
