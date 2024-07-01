package uk.co.harnick.troupetent.core.settings.presentation

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import uk.co.harnick.troupetent.common.servicelocator.modules.IODispatcher
import uk.co.harnick.troupetent.core.settings.domain.SettingsRepo
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection
import uk.co.harnick.troupetent.core.settings.domain.model.accessibility.AccessibilitySettings
import uk.co.harnick.troupetent.core.settings.domain.model.accessibility.toAccessibilitySettings
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.display.toDisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.toGeneralSettings
import uk.co.harnick.troupetent.core.settings.domain.model.update
import uk.co.harnick.troupetent.core.settings.presentation.SettingsEvent.ClearCollection
import uk.co.harnick.troupetent.core.settings.presentation.SettingsEvent.UpdateCollection
import uk.co.harnick.troupetent.core.ui.presentation.StatefulViewModel

class SettingsVM(
    ioDispatcher: IODispatcher,
    private val settingsRepo: SettingsRepo
) : StatefulViewModel<SettingsState, SettingsEvent>(SettingsState()) {
    override fun onEvent(event: SettingsEvent) {
        when (event) {
            is ClearCollection -> when (event.collection) {
                is DisplaySettings -> settingsRepo.resetDisplaySettings()
                is GeneralSettings -> settingsRepo.resetGeneralSettings()
            }

            is UpdateCollection -> {
                val updatedCollection = event.collection.update(event.newSetting)
                saveSettings(updatedCollection)
            }
        }
    }

    private fun saveSettings(updatedCollection: SettingCollection) {
        when (updatedCollection) {
            is DisplaySettings -> settingsRepo.saveDisplaySettings(updatedCollection)
            is GeneralSettings -> settingsRepo.saveGeneralSettings(updatedCollection)
        }
    }

    val accessibilitySettings = settingsRepo.getAccessibilitySettings(vmContext)
        .flowOn(ioDispatcher)
        .map { it?.toAccessibilitySettings() ?: AccessibilitySettings() }
        .stateIn(
            scope = vmScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    val displaySettings = settingsRepo.getDisplaySettings(vmContext)
        .flowOn(ioDispatcher)
        .map { it?.toDisplaySettings() ?: DisplaySettings() }
        .stateIn(
            scope = vmScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    val generalSettings = settingsRepo.getGeneralSettings(vmContext)
        .flowOn(ioDispatcher)
        .map { it?.toGeneralSettings() ?: GeneralSettings() }
        .stateIn(
            scope = vmScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    val allSettingsLoaded = combine(
        accessibilitySettings,
        displaySettings,
        generalSettings
    ) { settings -> settings.all { it != null } }
        .distinctUntilChanged()
        .onEach { delay(1000L) }
        .stateIn(
            scope = vmScope,
            started = SharingStarted.Eagerly,
            initialValue = false
        )
}
