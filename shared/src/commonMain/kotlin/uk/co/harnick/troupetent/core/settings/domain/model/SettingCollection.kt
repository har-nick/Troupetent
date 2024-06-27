package uk.co.harnick.troupetent.core.settings.domain.model

import org.jetbrains.compose.resources.DrawableResource
import java.security.InvalidParameterException

interface SettingCollection {
    val icon: DrawableResource
    val title: String
    val summary: String
    val entries: List<Setting<*>>
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
