package uk.co.harnick.troupetent.common.navigation.presentation

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Expanded
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Companion.Medium
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import uk.co.harnick.troupetent.common.navigation.presentation.Screen.Access
import uk.co.harnick.troupetent.common.navigation.presentation.Screen.Library
import uk.co.harnick.troupetent.common.navigation.presentation.Screen.Playlists
import uk.co.harnick.troupetent.common.navigation.presentation.Screen.Radio
import uk.co.harnick.troupetent.common.navigation.presentation.components.ExpandableNavigationRail
import uk.co.harnick.troupetent.common.navigation.presentation.components.ExpandableNavigationRailItem

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun NavigationManager(isLoggedIn: Boolean) {
    val windowWidth = calculateWindowSizeClass().widthSizeClass
    var currentScreen by rememberSaveable(isLoggedIn) {
        mutableStateOf(if (isLoggedIn) Library else Access)
    }

    when (windowWidth) {
        Medium, Expanded -> {
            var isExpanded by remember { mutableStateOf(false) }

            ExpandableNavigationRail(
                isExpanded = isExpanded,
                onToggleExpand = { isExpanded = !isExpanded }
            ) {
                ExpandableNavigationRailItem(
                    isExpanded = isExpanded,
                    isSelected = (currentScreen == Library),
                    onNavigate = { currentScreen = Library },
                    isEnabled = isLoggedIn
                ) {

                }

                ExpandableNavigationRailItem(
                    isExpanded = isExpanded,
                    isSelected = (currentScreen == Playlists),
                    onNavigate = { currentScreen = Playlists },
                    isEnabled = isLoggedIn,
                ) {

                }

                ExpandableNavigationRailItem(
                    isExpanded = isExpanded,
                    isSelected = (currentScreen == Radio),
                    onNavigate = { currentScreen = Radio },
                    isEnabled = isLoggedIn,
                ) {

                }
            }
        }
    }
}
