package uk.co.harnick.troupetent.core.settings.data.local.adapters

import app.cash.sqldelight.ColumnAdapter
import uk.co.harnick.troupetent.core.settings.domain.model.EnumSettingValue
import uk.co.harnick.troupetent.core.settings.domain.model.Setting

object EnumSettingAdapter {
    inline operator fun <reified T : Setting<R>, reified R : EnumSettingValue> invoke(): ColumnAdapter<T, String> {
        return object : ColumnAdapter<T, String> {
            override fun decode(databaseValue: String): T {
                val matchedEnum =
                    R::class.java.enumConstants!!.find { it.label == databaseValue }!!

                return T::class.java
                    .getConstructor(R::class.java)
                    .newInstance(matchedEnum)
            }

            override fun encode(value: T): String = value.value.label
        }
    }
}
