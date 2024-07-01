package uk.co.harnick.troupetent.core.ui.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.co.harnick.troupetent.core.design.ComponentDesign
import uk.co.harnick.troupetent.core.design.ComponentDesign.Material
import uk.co.harnick.troupetent.core.design.DesignException.MissingComponentImplementation
import uk.co.harnick.troupetent.core.design.LocalDesign
import androidx.compose.material3.Text as Material3Text

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    componentDesign: ComponentDesign = LocalDesign.current.components
) {
    when (componentDesign) {
        is Material.M3 -> Material3Text(text, modifier)
        else -> throw MissingComponentImplementation("Text", componentDesign)
    }
}
