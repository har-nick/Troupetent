package uk.co.harnick.troupetent.common.navigation.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import cafe.adriel.voyager.androidx.AndroidScreenLifecycleOwner
import cafe.adriel.voyager.navigator.Navigator

@Composable
actual fun AtomicContextLeakFix(navigator: Navigator) {
    DisposableEffect(Unit) {
        onDispose {
            for (screen in navigator.items) {
                AndroidScreenLifecycleOwner.get(screen).onDispose(screen)
            }
        }
    }
}
