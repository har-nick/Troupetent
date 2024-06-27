package uk.co.harnick.troupetent.core.settings.domain.model.display

import org.jetbrains.compose.resources.DrawableResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.palette_filled
import uk.co.harnick.troupetent.core.settings.domain.model.Setting

actual class MaterialYouIshSetting actual constructor(
    override val value: Boolean
) : Setting<Boolean> {
    override val description: String? = null
    override val helpLink: String? = null
    override val icon: DrawableResource = Res.drawable.palette_filled
    override val isVisible: Boolean = false
    override val title: String = "Material You-Ish"
    override val warning: String? = null
}
