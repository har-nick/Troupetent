package uk.co.harnick.troupetent.core.ui.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement.Maximized
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension

@Composable
fun ApplicationScope.MainWindow(
    content: @Composable () -> Unit
) {
    val windowState = rememberWindowState(
        width = 1400.dp,
        height = 800.dp,
        position = WindowPosition.Aligned(Alignment.Center)
    )

    val windowShape = when (windowState.placement) {
        Maximized -> RoundedCornerShape(0.dp)
        else -> MaterialTheme.shapes.large
    }

    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "Troupetent",
        undecorated = true,
        transparent = true
    ) {
        window.minimumSize = Dimension(1200, 800)

        Surface(
            modifier = Modifier
                .clip(windowShape)
                .fillMaxSize()
        ) {
            content()
        }
    }
}
