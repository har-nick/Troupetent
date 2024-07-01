package uk.co.harnick.troupetent.core.settings.presentation

import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection

sealed interface SettingsEvent {
    class ClearCollection(val collection: SettingCollection) : SettingsEvent

    class UpdateCollection(
        val newSetting: Setting<*>,
        val collection: SettingCollection
    ) : SettingsEvent
}
