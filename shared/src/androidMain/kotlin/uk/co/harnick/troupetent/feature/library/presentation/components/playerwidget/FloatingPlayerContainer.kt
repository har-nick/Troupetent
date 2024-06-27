package uk.co.harnick.troupetent.feature.library.presentation.components.playerwidget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex

@Composable
fun FloatingPlayerContainer(isVisible: Boolean, content: @Composable BoxScope.() -> Unit) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically { it / 2 },
        exit = slideOutVertically { it / 2 }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1F),
            contentAlignment = Alignment.BottomCenter,
            content = content
        )
    }
}
