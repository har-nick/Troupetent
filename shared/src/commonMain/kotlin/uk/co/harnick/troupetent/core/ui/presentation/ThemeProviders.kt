package uk.co.harnick.troupetent.core.ui.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import uk.co.harnick.troupetent.core.design.Design
import uk.co.harnick.troupetent.core.design.DesignTokens
import uk.co.harnick.troupetent.core.design.LocalDesign
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings

@Composable
fun ThemeProviders(
    displaySettings: DisplaySettings,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalDesign provides DesignTokens(displaySettings)
    ) {
        // Can't override Material 3's CompositionLocal as it's internal, so using MaterialTheme
        Design.colors.toMaterialTheme {
            content()
        }
    }
}
