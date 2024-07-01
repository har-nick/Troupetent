package uk.co.harnick.troupetent.core.settings.domain.model.display

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.troupetent.core.design.Design
import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.display.ImageQuality.Medium

class ArtQualitySetting(
    override val value: ImageQuality = Medium
) : Setting<ImageQuality>(
    value = value,
    title = "Image Quality"
) {
    override val icon: ImageVector
        @Composable
        get() = Design.icons.language.filled

    override val description: String? = null
    override val helpLink: String? = null
    override val warning: String = "Larger images take longer to load"
    override val isVisible: Boolean = true
}
