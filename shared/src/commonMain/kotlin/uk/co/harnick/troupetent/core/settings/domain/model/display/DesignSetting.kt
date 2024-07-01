package uk.co.harnick.troupetent.core.settings.domain.model.display

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.troupetent.core.design.ComponentDesign
import uk.co.harnick.troupetent.core.design.Design
import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.util.DeviceInfo

class DesignSetting(
    override val value: ComponentDesign = ComponentDesign.Material.M3(
        materialYouEnabled = DeviceInfo.materialYouSupported
    )
) : Setting<ComponentDesign>(
    value = value,
    title = "Designs"
) {
    override val icon: ImageVector
        @Composable
        get() = Design.icons.language.filled

    override val description: String? = null
    override val helpLink: String? = null
    override val warning: String? = null
    override val isVisible: Boolean = true
}
