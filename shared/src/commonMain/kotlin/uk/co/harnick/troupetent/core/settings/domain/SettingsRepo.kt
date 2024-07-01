package uk.co.harnick.troupetent.core.settings.domain

import kotlinx.coroutines.flow.Flow
import uk.co.harnick.troupetent.core.settings.domain.model.accessibility.AccessibilitySettings
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.troupetent.local.settings.AccessibilitySettingsEntity
import uk.co.harnick.troupetent.local.settings.DisplaySettingsEntity
import uk.co.harnick.troupetent.local.settings.GeneralSettingsEntity
import kotlin.coroutines.CoroutineContext

interface SettingsRepo {
    fun resetSettings()

    fun getAccessibilitySettings(mapperContext: CoroutineContext): Flow<AccessibilitySettingsEntity?>
    fun saveAccessibilitySettings(newCollection: AccessibilitySettings)
    fun resetAccessibilitySettings()

    fun getDisplaySettings(mapperContext: CoroutineContext): Flow<DisplaySettingsEntity?>
    fun saveDisplaySettings(newCollection: DisplaySettings)
    fun resetDisplaySettings()

    fun getGeneralSettings(mapperContext: CoroutineContext): Flow<GeneralSettingsEntity?>
    fun saveGeneralSettings(newCollection: GeneralSettings)
    fun resetGeneralSettings()
}
