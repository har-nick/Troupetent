package uk.co.harnick.troupetent.core.settings.domain.model.display

import org.jetbrains.compose.resources.DrawableResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.photo_size_select_small
import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.display.ImageQuality.Low

class ArtQualitySetting(
    override val value: ImageQuality = Low
) : Setting<ImageQuality> {
    override val description: String? = null
    override val helpLink: String? = null
    override val icon: DrawableResource = Res.drawable.photo_size_select_small
    override val isVisible: Boolean = true
    override val title: String = "Image Quality"
    override val warning: String = "Larger images take longer to load"
}
