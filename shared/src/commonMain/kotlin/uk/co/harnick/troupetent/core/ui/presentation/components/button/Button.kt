package uk.co.harnick.troupetent.core.ui.presentation.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.co.harnick.troupetent.core.design.ComponentDesign
import uk.co.harnick.troupetent.core.design.ComponentDesign.Material
import uk.co.harnick.troupetent.core.design.DesignException.MissingComponentImplementation
import uk.co.harnick.troupetent.core.design.LocalDesign
import androidx.compose.material3.Button as Material3Button

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    componentDesign: ComponentDesign = LocalDesign.current.components,
    content: @Composable () -> Unit
) {
    when (componentDesign) {
        is Material.M3 -> Material3Button(onClick, modifier) { content() }
        else -> throw MissingComponentImplementation("Button", componentDesign)
    }
}
