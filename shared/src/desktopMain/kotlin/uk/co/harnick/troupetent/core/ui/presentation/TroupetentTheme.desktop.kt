package uk.co.harnick.troupetent.core.ui.presentation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.materialkolor.AnimatedDynamicMaterialTheme
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.display.Theme.Auto
import uk.co.harnick.troupetent.core.settings.domain.model.display.Theme.Dark
import uk.co.harnick.troupetent.core.settings.domain.model.display.Theme.Light

actual object TroupetentTheme {
    @Composable
    actual operator fun invoke(displaySettings: DisplaySettings, content: @Composable () -> Unit) {
        val deviceIsInDarkMode = isSystemInDarkTheme()

        val seedColor by remember { derivedStateOf { displaySettings.seedColor.value } }
        val palette by remember { derivedStateOf { displaySettings.palette.value.style } }
        val theme by remember { derivedStateOf { displaySettings.theme.value } }

        val useDarkTheme = when (theme) {
            Dark -> true
            Light -> false
            Auto -> deviceIsInDarkMode
        }

        AnimatedDynamicMaterialTheme(seedColor, useDarkTheme, palette) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                content = content
            )
        }
    }
}
