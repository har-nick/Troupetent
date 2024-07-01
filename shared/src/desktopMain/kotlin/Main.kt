import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.application
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator.viewModelModule
import uk.co.harnick.troupetent.core.Troupetent
import uk.co.harnick.troupetent.core.ui.presentation.ThemeProviders
import uk.co.harnick.troupetent.core.ui.presentation.components.MainWindow
import uk.co.harnick.troupetent.core.ui.presentation.components.Splash

fun main() = application {
    // NOTE: I'd put this in ViewModelModule, but nullability can't be inferred.
    val allSettingsLoaded by viewModelModule.settingsVM.allSettingsLoaded.collectAsState()
    val displaySettings by viewModelModule.settingsVM.displaySettings.collectAsState()

    val isReady = (allSettingsLoaded)

    displaySettings?.let {
        ThemeProviders(it) {
            if (!isReady) Splash()
            else MainWindow {
                Troupetent()
            }
        }
    }
}
