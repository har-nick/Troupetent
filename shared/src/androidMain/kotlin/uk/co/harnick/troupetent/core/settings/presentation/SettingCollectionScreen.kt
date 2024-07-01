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
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.troupetent.core.settings.presentation.components.SettingCollectionTopBar
import uk.co.harnick.troupetent.core.settings.presentation.components.ToSettingEntry
import java.security.InvalidParameterException

object SettingCollectionScreen : Screen {
    private val settingsVM = ServiceLocator.viewModelModule.settingsViewModel
    private val settingsEvent = settingsVM::onEvent

    @Composable
    override fun Content() {
        val state by settingsVM.state.collectAsState()

        val collection = when (state.currentlyViewedSettings) {
            DisplaySettings::class -> state.displaySettings
            GeneralSettings::class -> state.generalSettings
            else -> throw InvalidParameterException("${state.currentlyViewedSettings!!.simpleName} settings is not passed to state")
        }
        val filteredSettings = collection.entries.filter { it.isVisible }

        Scaffold(
            topBar = { SettingCollectionTopBar(collection, settingsEvent) }
        ) { scaffoldPadding ->
            LazyColumn(modifier = Modifier.padding(scaffoldPadding)) {
                items(filteredSettings) { it.ToSettingEntry(collection, settingsEvent) }
            }
        }
    }
}
