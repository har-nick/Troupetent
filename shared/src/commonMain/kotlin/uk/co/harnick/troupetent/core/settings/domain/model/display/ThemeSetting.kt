package uk.co.harnick.troupetent.core.settings.domain.model.display

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.troupetent.core.design.Design
import uk.co.harnick.troupetent.core.design.color.ColorTokens
import uk.co.harnick.troupetent.core.design.color.DefaultColorDesign
import uk.co.harnick.troupetent.core.settings.domain.model.Setting

class ThemeSetting(
    override val value: ColorTokens = DefaultColorDesign
) : Setting<ColorTokens>(
    value = value,
    title = "Themes"
) {
    override val icon: ImageVector
        @Composable
        get() = Design.icons.language.filled

    override val description: String? = null
    override val helpLink: String? = null
    override val warning: String? = null
    override val isVisible: Boolean = true
}
