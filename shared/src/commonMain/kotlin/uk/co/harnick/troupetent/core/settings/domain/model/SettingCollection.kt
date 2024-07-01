package uk.co.harnick.troupetent.core.settings.domain.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import java.security.InvalidParameterException

open class SettingCollection(
    open val title: String
) {
    open val icon: ImageVector?
        @Composable
        get() = null

    open val summary: String? = null
}

fun SettingCollection.update(newSetting: Setting<*>): SettingCollection {
    val copiedSettings = this

    copiedSettings.javaClass.declaredFields
        .find { it.type == newSetting.javaClass && it.type.isAssignableFrom(newSetting.javaClass) }
        ?.apply {
            isAccessible = true
            set(copiedSettings, newSetting)
        }
        ?: throw InvalidParameterException(
            "${newSetting::class.simpleName} is not a parameter of ${copiedSettings::class.simpleName}"
        )

    return copiedSettings
}
