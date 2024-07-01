package uk.co.harnick.troupetent.core.ui.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberWindowState
import uk.co.harnick.troupetent.core.design.Design

@Composable
fun ApplicationScope.Splash() {
    // Values hoisted as mismatching Window and Column sizes stop centre-aligned working
    val windowSize = DpSize(150.dp, 150.dp)

    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            size = windowSize
        ),
        title = "Troupetent - Splash",
        undecorated = true,
        transparent = true,
        resizable = false,
        alwaysOnTop = true
    ) {
        Box(
            modifier = Modifier.size(windowSize),
            contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = Design.icons.language.filled,
                contentDescription = null,
                modifier = Modifier.size(70.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}
