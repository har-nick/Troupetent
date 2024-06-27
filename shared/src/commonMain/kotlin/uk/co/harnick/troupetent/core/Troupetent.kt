package uk.co.harnick.troupetent.core

import androidx.compose.animation.core.tween
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.transitions.FadeTransition
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import uk.co.harnick.troupetent.common.navigation.presentation.NavigationManager
import uk.co.harnick.troupetent.core.ui.presentation.TroupetentTheme
import java.time.ZonedDateTime
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator.viewModelModule as ViewModelModule

@Composable
fun Troupetent() {
    val settingsState by ViewModelModule.settingsViewModel.state.collectAsState()

    NavigationManager { navigator ->
        TroupetentTheme(settingsState.displaySettings) {
            Surface {
                FadeTransition(
                    navigator = navigator,
                    animationSpec = tween(durationMillis = 200),
                    content = { screen -> screen.Content() }
                )
            }
        }
    }
}
