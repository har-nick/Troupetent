package uk.co.harnick.troupetent.core.settings.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator
import uk.co.harnick.troupetent.core.settings.presentation.components.SettingsTopAppBar
import uk.co.harnick.troupetent.core.settings.presentation.components.ToCollectionEntry

actual object SettingsScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val settingsVM = ServiceLocator.viewModelModule.settingsViewModel
        val settingsState by settingsVM.state.collectAsState()

        Scaffold(
            topBar = { SettingsTopAppBar() }
        ) { scaffoldPadding ->
            LazyColumn(
                modifier = Modifier.padding(scaffoldPadding)
            ) {
                items(settingsState.entries) { collection ->
                    collection.ToCollectionEntry {
                        navigator.push(SettingCollectionScreen(collection))
                    }
                }
            }
        }
    }
}
