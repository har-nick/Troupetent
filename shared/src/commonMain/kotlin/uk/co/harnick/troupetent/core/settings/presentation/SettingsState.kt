package uk.co.harnick.troupetent.core.settings.presentation

import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.GeneralSettings
import kotlin.reflect.KClass

data class SettingsState(
    val currentlyViewedSettings: KClass<out SettingCollection>? = null,
    val displaySettings: DisplaySettings = DisplaySettings(),
    val generalSettings: GeneralSettings = GeneralSettings()
) {
    val entries = listOf(displaySettings, generalSettings)
}
