package uk.co.harnick.troupetent.core.settings.presentation

import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection

sealed interface SettingsEvent {
    sealed interface VM : SettingsEvent

    sealed interface Screen : SettingsEvent {
        class ClearCollection(val collection: SettingCollection) : SettingsEvent

        class UpdateCollection(
            val newSetting: Setting<*>,
            val collection: SettingCollection
        ) : SettingsEvent

        class SetViewedCollection(val collection: SettingCollection) : SettingsEvent
    }
}
