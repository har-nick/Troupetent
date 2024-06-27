package uk.co.harnick.troupetent.core.settings.presentation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import uk.co.harnick.troupetent.common.servicelocator.modules.IODispatcher
import uk.co.harnick.troupetent.core.settings.domain.mappers.DisplaySettingsMappers.toDisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.mappers.GeneralSettingsMappers.toGeneralSettings
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.troupetent.core.settings.domain.model.update
import uk.co.harnick.troupetent.core.settings.domain.repository.SettingsRepo
import uk.co.harnick.troupetent.core.settings.presentation.SettingsEvent.Screen.ClearCollection
import uk.co.harnick.troupetent.core.settings.presentation.SettingsEvent.Screen.UpdateCollection
import uk.co.harnick.troupetent.core.settings.presentation.SettingsEvent.VM
import uk.co.harnick.troupetent.core.ui.presentation.StatefulViewModel

class SettingsViewModel(
    ioDispatcher: IODispatcher,
    private val settingsRepo: SettingsRepo
) : StatefulViewModel<SettingsState, SettingsEvent>(SettingsState()) {
    override fun onEvent(event: SettingsEvent) {
        when (event) {
            is VM -> {}
            is UpdateCollection<*> -> {
                val updatedCollection = event.collection.update(event.newSetting)
                saveSettings(updatedCollection)
            }

            is ClearCollection<*> -> when (event.collection) {
                is DisplaySettings -> settingsRepo.resetDisplaySettings()
                is GeneralSettings -> settingsRepo.resetGeneralSettings()
            }
        }
    }

    private fun saveSettings(updatedCollection: SettingCollection) {
        when (updatedCollection) {
            is DisplaySettings -> settingsRepo.saveDisplaySettings(updatedCollection)
            is GeneralSettings -> settingsRepo.saveGeneralSettings(updatedCollection)
        }
    }

    private fun getSettingsAsState(): Flow<SettingsState> {
        val generalSettingsFlow = settingsRepo.getGeneralSettings(vmContext)
            .map { it?.toGeneralSettings() ?: GeneralSettings() }

        val displaySettingsFlow = settingsRepo.getDisplaySettings(vmContext)
            .map { it?.toDisplaySettings() ?: DisplaySettings() }

        return combine(
            displaySettingsFlow,
            generalSettingsFlow
        ) { displaySettings, generalSettings ->
            SettingsState(
                displaySettings = displaySettings,
                generalSettings = generalSettings
            )
        }
    }

    init {
        getSettingsAsState()
            .flowOn(ioDispatcher)
            .onEach { newState ->
                mutableState.update { oldState ->
                    oldState.copy(
                        displaySettings = newState.displaySettings,
                        generalSettings = newState.generalSettings
                    )
                }
            }
            .launchIn(vmScope)
    }
}
