package uk.co.harnick.troupetent.core.design

import androidx.compose.runtime.staticCompositionLocalOf
import uk.co.harnick.troupetent.core.design.color.ColorTokens
import uk.co.harnick.troupetent.core.design.color.DefaultColorDesign
import uk.co.harnick.troupetent.core.design.components.DefaultComponents
import uk.co.harnick.troupetent.core.design.icons.DefaultIconDesign
import uk.co.harnick.troupetent.core.design.icons.IconTokens
import uk.co.harnick.troupetent.core.design.typography.DefaultTypography
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings

class DesignTokens(
    val colorTokens: ColorTokens,
    val components: ComponentDesign,
    val icon: IconTokens,
    val typography: Typography
) {
    constructor(displaySettings: DisplaySettings) : this(
        displaySettings.theme.value,
        displaySettings.componentDesign.value,
        displaySettings.icons.value.toTokens(),
        displaySettings.font.value
    )
}

val LocalDesign = staticCompositionLocalOf {
    DesignTokens(
        colorTokens = DefaultColorDesign,
        components = DefaultComponents,
        icon = DefaultIconDesign.toTokens(),
        typography = DefaultTypography
    )
}
