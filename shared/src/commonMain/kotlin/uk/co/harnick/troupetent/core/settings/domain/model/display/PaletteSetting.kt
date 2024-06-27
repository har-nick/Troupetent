package uk.co.harnick.troupetent.core.settings.domain.model.display

import org.jetbrains.compose.resources.DrawableResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.style_filled
import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.display.Palette.Content

class PaletteSetting(
    override val value: Palette = Content
) : Setting<Palette> {
    override val description: String = "Customise further with theme palettes"
    override val helpLink: String? = null
    override val icon: DrawableResource = Res.drawable.style_filled
    override val isVisible: Boolean = true
    override val title: String = "Palette"
    override val warning: String? = null
}
