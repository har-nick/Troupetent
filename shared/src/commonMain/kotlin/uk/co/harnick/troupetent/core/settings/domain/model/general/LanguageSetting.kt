package uk.co.harnick.troupetent.core.settings.domain.model.general

import org.jetbrains.compose.resources.DrawableResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.language
import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.general.Language.English

class LanguageSetting(
    override val value: Language = English
) : Setting<Language> {
    override val description: String? = null
    override val helpLink: String? = null
    override val icon: DrawableResource = Res.drawable.language
    override val isVisible: Boolean = true
    override val title: String = "LANGUAGE SETTING TITLE"
    override val warning: String? = null
}
