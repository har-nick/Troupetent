package uk.co.harnick.troupetent.core.settings.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToOneOrNull
import kotlinx.coroutines.flow.Flow
import uk.co.harnick.troupetent.LocalStorage
import uk.co.harnick.troupetent.core.settings.domain.SettingsRepo
import uk.co.harnick.troupetent.core.settings.domain.model.accessibility.AccessibilitySettings
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.troupetent.local.settings.AccessibilitySettingsEntity
import uk.co.harnick.troupetent.local.settings.DisplaySettingsEntity
import uk.co.harnick.troupetent.local.settings.GeneralSettingsEntity
import kotlin.coroutines.CoroutineContext

class SettingsRepoImpl(db: LocalStorage) : SettingsRepo {
    private val accessibilityQueries = db.accessibility_settingsQueries
    private val displayQueries = db.display_settingsQueries
    private val generalQueries = db.general_settingsQueries

    override fun resetSettings() {
        accessibilityQueries.drop()
        displayQueries.drop()
        generalQueries.drop()
    }

    override fun getAccessibilitySettings(mapperContext: CoroutineContext): Flow<AccessibilitySettingsEntity?> =
        accessibilityQueries.load()
            .asFlow()
            .mapToOneOrNull(mapperContext)

    override fun saveAccessibilitySettings(newCollection: AccessibilitySettings) =
        accessibilityQueries.save(
            newCollection.leftHandedMode
        )

    override fun resetAccessibilitySettings() = accessibilityQueries.drop()

    override fun getDisplaySettings(mapperContext: CoroutineContext): Flow<DisplaySettingsEntity?> =
        displayQueries.load()
            .asFlow()
            .mapToOneOrNull(mapperContext)

    override fun saveDisplaySettings(newCollection: DisplaySettings) =
        displayQueries.save(
            newCollection.artQuality,
            newCollection.componentDesign,
            newCollection.font,
            newCollection.icons,
            newCollection.theme
        )

    override fun resetDisplaySettings() = displayQueries.drop()

    override fun getGeneralSettings(mapperContext: CoroutineContext): Flow<GeneralSettingsEntity?> =
        generalQueries.load()
            .asFlow()
            .mapToOneOrNull(mapperContext)

    override fun saveGeneralSettings(newCollection: GeneralSettings) =
        generalQueries.save(newCollection.language, newCollection.writeMetadataToDownloads)

    override fun resetGeneralSettings() = generalQueries.drop()
}
