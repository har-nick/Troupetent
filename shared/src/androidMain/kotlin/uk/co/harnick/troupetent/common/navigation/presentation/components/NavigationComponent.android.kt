package uk.co.harnick.troupetent.common.navigation.presentation.components

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Compact
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import uk.co.harnick.troupetent.common.navigation.presentation.components.rail.NavRail

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
actual fun NavigationComponent() {
    if (calculateWindowSizeClass().widthSizeClass != Compact) NavRail()
}
