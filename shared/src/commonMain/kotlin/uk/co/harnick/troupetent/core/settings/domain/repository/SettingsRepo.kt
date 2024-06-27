package uk.co.harnick.troupetent.core.settings.domain.repository

import kotlinx.coroutines.flow.Flow
import uk.co.harnick.troupetent.DisplaySettingsEntity
import uk.co.harnick.troupetent.GeneralSettingsEntity
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.GeneralSettings
import kotlin.coroutines.CoroutineContext

interface SettingsRepo {
    fun resetSettings()

    fun getDisplaySettings(mapperContext: CoroutineContext): Flow<DisplaySettingsEntity?>
    fun saveDisplaySettings(newCollection: DisplaySettings)
    fun resetDisplaySettings()

    fun getGeneralSettings(mapperContext: CoroutineContext): Flow<GeneralSettingsEntity?>
    fun saveGeneralSettings(newCollection: GeneralSettings)
    fun resetGeneralSettings()
}
