package uk.co.harnick.troupetent.core.settings.domain.model.general

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.troupetent.core.design.Design
import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.general.Language.English

class LanguageSetting(
    override val value: Language = English
) : Setting<Language>(
    value = value,
    title = "LANGUAGE SETTING TITLE"
) {
    override val icon: ImageVector
        @Composable
        get() = Design.icons.language.filled

    override val description: String? = null
    override val helpLink: String? = null
    override val warning: String? = null
    override val isVisible: Boolean = true
}
