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
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.troupetent.core.settings.presentation.components.SettingCollectionTopBar
import uk.co.harnick.troupetent.core.settings.presentation.components.ToSettingEntry
import java.security.InvalidParameterException

class SettingCollectionScreen<T : SettingCollection>(private val collection: T) : Screen {
    private val settingsVM = ServiceLocator.viewModelModule.settingsViewModel
    private val settingsEvent = settingsVM::onEvent

    @Composable
    override fun Content() {
        val state by settingsVM.state.collectAsState()
        val settings = when (collection) {
            is DisplaySettings -> state.displaySettings
            is GeneralSettings -> state.generalSettings
            else -> throw InvalidParameterException("${collection::class.simpleName} is not passed to state")
        }.entries.filter { it.isVisible }

        Scaffold(
            topBar = { SettingCollectionTopBar(collection, settingsEvent) }
        ) { scaffoldPadding ->
            LazyColumn(modifier = Modifier.padding(scaffoldPadding)) {
                items(settings) { it.ToSettingEntry(collection, settingsEvent) }
            }
        }
    }
}
