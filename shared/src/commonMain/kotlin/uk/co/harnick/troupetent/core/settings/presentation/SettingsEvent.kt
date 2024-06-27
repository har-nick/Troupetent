package uk.co.harnick.troupetent.core.settings.presentation

import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection

sealed interface SettingsEvent {
    sealed interface VM : SettingsEvent

    sealed interface Screen : SettingsEvent {
        data class UpdateCollection<T : SettingCollection>(
            val newSetting: Setting<*>,
            val collection: T
        ) : SettingsEvent

        class ClearCollection<T : SettingCollection>(val collection: T) : SettingsEvent
    }
}
