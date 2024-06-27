package uk.co.harnick.troupetent.core.settings.domain.mappers

import uk.co.harnick.troupetent.DisplaySettingsEntity
import uk.co.harnick.troupetent.core.settings.domain.model.display.ArtQualitySetting
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.display.MaterialYouIshSetting
import uk.co.harnick.troupetent.core.settings.domain.model.display.MaterialYouSetting
import uk.co.harnick.troupetent.core.settings.domain.model.display.PaletteSetting
import uk.co.harnick.troupetent.core.settings.domain.model.display.SeedColorSetting
import uk.co.harnick.troupetent.core.settings.domain.model.display.ThemeSetting

object DisplaySettingsAdapters {
    fun DisplaySettingsEntity.toDisplaySettings() = DisplaySettings(
        artQuality ?: ArtQualitySetting(),
        materialYou ?: MaterialYouSetting(),
        materialYouIsh ?: MaterialYouIshSetting(),
        palette ?: PaletteSetting(),
        seedColor ?: SeedColorSetting(),
        theme ?: ThemeSetting()
    )
}
