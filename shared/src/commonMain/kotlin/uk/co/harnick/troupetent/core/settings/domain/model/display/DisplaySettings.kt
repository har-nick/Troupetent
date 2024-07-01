package uk.co.harnick.troupetent.core.settings.domain.model.display

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.troupetent.core.design.Design
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection
import uk.co.harnick.troupetent.local.settings.DisplaySettingsEntity

data class DisplaySettings(
    val artQuality: ArtQualitySetting = ArtQualitySetting(),
    val componentDesign: DesignSetting = DesignSetting(),
    val font: FontSetting = FontSetting(),
    val icons: IconsSetting = IconsSetting(),
    val theme: ThemeSetting = ThemeSetting(),
) : SettingCollection(
    title = "Display"
) {
    override val icon: ImageVector
        @Composable
        get() = Design.icons.language.filled

    override val summary: String = "Themes and Component Designs"
}

fun DisplaySettingsEntity.toDisplaySettings() =
    DisplaySettings(
        artQuality ?: ArtQualitySetting(),
        design ?: DesignSetting(),
        font ?: FontSetting(),
        icons ?: IconsSetting(),
        theme ?: ThemeSetting()
    )
