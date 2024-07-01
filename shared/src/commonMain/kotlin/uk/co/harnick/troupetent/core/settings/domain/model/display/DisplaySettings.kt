package uk.co.harnick.troupetent.core.settings.domain.model.display

import org.jetbrains.compose.resources.DrawableResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.display_settings_filled
import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection

data class DisplaySettings(
    val artQuality: ArtQualitySetting = ArtQualitySetting(),
    val materialYou: MaterialYouSetting = MaterialYouSetting(),
    val materialYouIsh: MaterialYouIshSetting = MaterialYouIshSetting(),
    val palette: PaletteSetting = PaletteSetting(),
    val seedColor: SeedColorSetting = SeedColorSetting(),
    val theme: ThemeSetting = ThemeSetting()
) : SettingCollection {
    override val icon: DrawableResource = Res.drawable.display_settings_filled
    override val summary: String = "Material You, Seed Colors, Palettes, & Themes"
    override val title: String = "Display"
    override val entries: List<Setting<*>> =
        listOf(theme, materialYou, materialYouIsh, seedColor, palette, artQuality)
}
