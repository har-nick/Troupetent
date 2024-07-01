package uk.co.harnick.troupetent.core.settings.domain.model.general

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.troupetent.core.design.Design
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection
import uk.co.harnick.troupetent.local.settings.GeneralSettingsEntity

data class GeneralSettings(
    val language: LanguageSetting = LanguageSetting(),
    val writeMetadataToDownloads: WriteMetadataToDownloadsSetting = WriteMetadataToDownloadsSetting(),
) : SettingCollection(
    title = "General"
) {
    override val icon: ImageVector
        @Composable
        get() = Design.icons.language.filled

    override val summary: String = "Language"
}

fun GeneralSettingsEntity.toGeneralSettings() =
    GeneralSettings(
        language = language ?: LanguageSetting(),
        writeMetadataToDownloads = writeMetadataToDownloads ?: WriteMetadataToDownloadsSetting()
    )
