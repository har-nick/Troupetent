package uk.co.harnick.troupetent.core.settings.presentation

import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.GeneralSettings

data class SettingsState(
    val displaySettings: DisplaySettings = DisplaySettings(),
    val generalSettings: GeneralSettings = GeneralSettings()
) {
    val entries = listOf(displaySettings, generalSettings)
}
