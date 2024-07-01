package uk.co.harnick.troupetent.core.settings.domain.model.display

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.troupetent.core.design.Design
import uk.co.harnick.troupetent.core.design.icons.IconDesign
import uk.co.harnick.troupetent.core.design.icons.material.MaterialIcons
import uk.co.harnick.troupetent.core.settings.domain.model.Setting

class IconsSetting(
    override val value: IconDesign = MaterialIcons
) : Setting<IconDesign>(
    value = value,
    title = ""
) {
    override val icon: ImageVector
        @Composable
        get() = Design.icons.language.filled

}
