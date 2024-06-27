package uk.co.harnick.troupetent.core.settings.domain.model.display

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.colorize_filled
import uk.co.harnick.troupetent.core.settings.domain.model.Setting

class SeedColorSetting(
    override val value: Color = Color(54, 115, 191)
) : Setting<Color> {
    override val description: String = "The deciding color for Troupetent's theme"
    override val helpLink: String? = null
    override val icon: DrawableResource = Res.drawable.colorize_filled
    override val isVisible: Boolean = true
    override val title: String = "Seed Color"
    override val warning: String? = null
}
