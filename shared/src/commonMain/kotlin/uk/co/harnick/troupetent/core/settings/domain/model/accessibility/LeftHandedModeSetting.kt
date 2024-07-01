package uk.co.harnick.troupetent.core.settings.domain.model.accessibility

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.troupetent.core.design.Design
import uk.co.harnick.troupetent.core.settings.domain.model.Setting

class LeftHandedModeSetting(
    override val value: Boolean = false
) : Setting<Boolean>(
    value = value,
    title = "Left-Handed Mode"
) {
    override val icon: ImageVector
        @Composable
        get() = Design.icons.language.filled

    override val description: String = "Rearranges some elements to be more reachable for left-handed users."
    override val helpLink: String? = null
    override val warning: String? = null
    override val isVisible: Boolean = true
}
