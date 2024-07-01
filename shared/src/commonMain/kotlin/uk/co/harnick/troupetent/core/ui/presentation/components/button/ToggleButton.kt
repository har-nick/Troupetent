package uk.co.harnick.troupetent.core.ui.presentation.components.button

import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import uk.co.harnick.troupetent.core.design.ComponentDesign
import uk.co.harnick.troupetent.core.design.ComponentDesign.Material
import uk.co.harnick.troupetent.core.design.DesignException.MissingComponentImplementation
import uk.co.harnick.troupetent.core.design.LocalDesign

@Composable
fun ToggleButton(
    isEnabled: Boolean,
    onClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    componentDesign: ComponentDesign = LocalDesign.current.components,
    content: @Composable () -> Unit
) {
    val modifier = modifier
        .then(
            Modifier.pointerHoverIcon(PointerIcon.Hand)
        )

    when (componentDesign) {
        is Material.M3 -> FilledIconToggleButton(isEnabled, onClick, modifier) { content() }
        else -> throw MissingComponentImplementation("ToggleButton", componentDesign)
    }
}
