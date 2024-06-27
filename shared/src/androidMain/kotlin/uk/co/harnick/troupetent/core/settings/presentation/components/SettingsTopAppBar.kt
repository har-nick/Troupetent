package uk.co.harnick.troupetent.core.settings.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import uk.co.harnick.troupetent.core.ui.presentation.components.NavigationBackArrow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsTopAppBar() {
    LargeTopAppBar(
        title = { Text(text = "Settings") },
        navigationIcon = { NavigationBackArrow() }
    )
}
