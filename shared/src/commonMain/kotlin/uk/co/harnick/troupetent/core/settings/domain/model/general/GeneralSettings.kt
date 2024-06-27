package uk.co.harnick.troupetent.core.settings.domain.model.general

import org.jetbrains.compose.resources.DrawableResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.language
import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection

data class GeneralSettings(
    val language: LanguageSetting = LanguageSetting(),
) : SettingCollection {
    override val icon: DrawableResource = Res.drawable.language
    override val title: String = "General"
    override val summary: String = "Language"
    override val entries: List<Setting<*>> = listOf(language)
}
