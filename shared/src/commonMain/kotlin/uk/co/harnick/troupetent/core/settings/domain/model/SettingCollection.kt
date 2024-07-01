package uk.co.harnick.troupetent.core.settings.domain.model

import org.jetbrains.compose.resources.DrawableResource
import java.security.InvalidParameterException

interface SettingCollection {
    val entries: List<Setting<*>>
    val icon: DrawableResource
    val summary: String
    val title: String
}

fun SettingCollection.update(newSetting: Setting<*>): SettingCollection {
    val copiedSettings = this

    copiedSettings.javaClass.declaredFields
        .find { it.type == newSetting.javaClass && it.type.isAssignableFrom(newSetting.javaClass) }
        ?.apply {
            isAccessible = true
            set(copiedSettings, newSetting)
        }
        ?: throw InvalidParameterException("${newSetting::class.simpleName} is not a parameter of ${copiedSettings::class.simpleName}")

    return copiedSettings
}
