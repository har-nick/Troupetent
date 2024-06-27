package uk.co.harnick.troupetent.core.settings.domain.model.display

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.R
import org.jetbrains.compose.resources.DrawableResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.palette_filled
import uk.co.harnick.troupetent.core.settings.domain.model.Setting

actual class MaterialYouIshSetting actual constructor(
    override val value: Boolean
) : Setting<Boolean> {
    actual override val description: String = "Mimics a Material You theme with some limitations"

    // TODO: ADD HELP LINK
    actual override val helpLink: String = ""
    override val icon: DrawableResource = Res.drawable.palette_filled
    override val isVisible: Boolean = (SDK_INT <= R)
    override val title: String = "Material You-Ish"
    override val warning: String? = null
}
