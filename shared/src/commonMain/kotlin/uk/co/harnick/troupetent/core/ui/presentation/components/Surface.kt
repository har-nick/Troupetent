package uk.co.harnick.troupetent.core.ui.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.co.harnick.troupetent.core.design.ComponentDesign
import uk.co.harnick.troupetent.core.design.ComponentDesign.Material
import uk.co.harnick.troupetent.core.design.DesignException.MissingComponentImplementation
import uk.co.harnick.troupetent.core.design.LocalDesign
import androidx.compose.material3.Surface as Material3Surface

@Composable
fun Surface(
    modifier: Modifier = Modifier,
    componentDesign: ComponentDesign = LocalDesign.current.components,
    content: @Composable () -> Unit
) {
    when (componentDesign) {
        is Material.M3 -> Material3Surface(modifier) { content() }
        else -> throw MissingComponentImplementation("Surface", componentDesign)
    }
}
