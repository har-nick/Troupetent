package uk.co.harnick.troupetent.core.design

import androidx.compose.runtime.Composable
import uk.co.harnick.troupetent.core.design.color.ColorTokens
import uk.co.harnick.troupetent.core.design.icons.IconTokens

object Design {
    val colors: ColorTokens
        @Composable
        get() = LocalDesign.current.colorTokens

    val components: ComponentDesign
        @Composable
        get() = LocalDesign.current.components

    val icons: IconTokens
        @Composable
        get() = LocalDesign.current.icon

    val typography: Typography
        @Composable
        get() = LocalDesign.current.typography
}
