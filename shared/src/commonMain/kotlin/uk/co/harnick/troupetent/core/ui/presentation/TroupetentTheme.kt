package uk.co.harnick.troupetent.core.ui.presentation

import androidx.compose.runtime.Composable
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings

expect object TroupetentTheme {
    @Composable
    operator fun invoke(
        displaySettings: DisplaySettings = DisplaySettings(),
        content: @Composable () -> Unit
    )
}
