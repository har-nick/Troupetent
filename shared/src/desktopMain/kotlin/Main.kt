import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import uk.co.harnick.troupetent.core.Troupetent
import uk.co.harnick.troupetent.core.ui.presentation.DesktopUriHandler
import java.awt.Dimension

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Troupetent",
        state = rememberWindowState(width = 1400.dp, height = 800.dp)
    ) {
        window.minimumSize = Dimension(850, 600)

        CompositionLocalProvider(LocalUriHandler provides DesktopUriHandler) {
            Troupetent()
        }
    }
}
