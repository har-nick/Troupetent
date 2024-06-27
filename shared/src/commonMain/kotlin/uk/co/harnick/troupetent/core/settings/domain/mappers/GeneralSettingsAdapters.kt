package uk.co.harnick.troupetent.core.settings.domain.mappers

import uk.co.harnick.troupetent.GeneralSettingsEntity
import uk.co.harnick.troupetent.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.LanguageSetting

object GeneralSettingsAdapters {
    fun GeneralSettingsEntity.toGeneralSettings() = GeneralSettings(
        language = language ?: LanguageSetting()
    )
}
