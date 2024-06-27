package uk.co.harnick.troupetent.core.settings.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToOneOrNull
import kotlinx.coroutines.flow.Flow
import uk.co.harnick.troupetent.DisplaySettingsEntity
import uk.co.harnick.troupetent.GeneralSettingsEntity
import uk.co.harnick.troupetent.LocalStorage
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.general.GeneralSettings
import uk.co.harnick.troupetent.core.settings.domain.repository.SettingsRepo
import kotlin.coroutines.CoroutineContext

class SettingsRepoImpl(db: LocalStorage) : SettingsRepo {
    private val displayQueries = db.display_settingsQueries
    private val generalQueries = db.general_settingsQueries

    override fun resetSettings() {
        displayQueries.drop()
        generalQueries.drop()
    }

    override fun getDisplaySettings(mapperContext: CoroutineContext): Flow<DisplaySettingsEntity?> =
        displayQueries.load().asFlow().mapToOneOrNull(mapperContext)

    override fun saveDisplaySettings(newCollection: DisplaySettings) =
        displayQueries.save(
            newCollection.artQuality,
            newCollection.materialYouIsh,
            newCollection.materialYou,
            newCollection.palette,
            newCollection.seedColor,
            newCollection.theme
        )

    override fun resetDisplaySettings() = displayQueries.drop()

    override fun getGeneralSettings(mapperContext: CoroutineContext): Flow<GeneralSettingsEntity?> =
        generalQueries.load().asFlow().mapToOneOrNull(mapperContext)

    override fun saveGeneralSettings(newCollection: GeneralSettings) =
        generalQueries.save(newCollection.language)

    override fun resetGeneralSettings() = generalQueries.drop()
}
