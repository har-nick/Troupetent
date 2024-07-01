package uk.co.harnick.troupetent.core

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import uk.co.harnick.troupetent.common.navigation.presentation.NavigationManager

@Composable
fun Troupetent() {
    Row {
        NavigationManager(isLoggedIn = true)
    }
}
