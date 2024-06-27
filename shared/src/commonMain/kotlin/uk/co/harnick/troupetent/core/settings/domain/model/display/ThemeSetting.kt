package uk.co.harnick.troupetent.core.settings.domain.model.display

import org.jetbrains.compose.resources.DrawableResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.format_paint_filled
import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.display.Theme.Auto

class ThemeSetting(
    override val value: Theme = Auto
) : Setting<Theme> {
    override val description: String? = null
    override val helpLink: String? = null
    override val icon: DrawableResource = Res.drawable.format_paint_filled
    override val isVisible: Boolean = true
    override val title: String = "Theme"
    override val warning: String? = null
}
