package uk.co.harnick.troupetent.core.db.data.local

import app.cash.sqldelight.adapter.primitive.IntColumnAdapter
import app.cash.sqldelight.db.SqlDriver
import uk.co.harnick.troupetent.LocalStorage
import uk.co.harnick.troupetent.bandcamp.LibrarySummaryEntity
import uk.co.harnick.troupetent.core.db.data.local.adapters.AnyToStringAdapter
import uk.co.harnick.troupetent.core.db.data.local.adapters.ZonedDateTimeAdapter
import uk.co.harnick.troupetent.core.settings.data.local.adapters.BooleanSettingAdapter
import uk.co.harnick.troupetent.core.settings.data.local.adapters.EnumSettingAdapter
import uk.co.harnick.troupetent.local.PlayerHistoryEntity
import uk.co.harnick.troupetent.local.PlaylistEntity
import uk.co.harnick.troupetent.local.settings.AccessibilitySettingsEntity
import uk.co.harnick.troupetent.local.settings.DisplaySettingsEntity
import uk.co.harnick.troupetent.local.settings.GeneralSettingsEntity

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createLocalStorage(driverFactory: DriverFactory): LocalStorage {
    val driver = driverFactory.createDriver()
    return LocalStorage(
        driver = driver,
        AccessibilitySettingsEntityAdapter = AccessibilitySettingsEntity.Adapter(
            leftHandedModeAdapter = BooleanSettingAdapter()
        ),
        DisplaySettingsEntityAdapter = DisplaySettingsEntity.Adapter(
            artQualityAdapter = EnumSettingAdapter(),
            designAdapter = AnyToStringAdapter(),
            fontAdapter = AnyToStringAdapter(),
            iconsAdapter = AnyToStringAdapter(),
            themeAdapter = AnyToStringAdapter()
        ),
        GeneralSettingsEntityAdapter = GeneralSettingsEntity.Adapter(
            languageAdapter = EnumSettingAdapter(),
            writeMetadataToDownloadsAdapter = BooleanSettingAdapter(),
        ),
        LibrarySummaryEntityAdapter = LibrarySummaryEntity.Adapter(
            itemCountAdapter = IntColumnAdapter
        ),
        PlayerHistoryEntityAdapter = PlayerHistoryEntity.Adapter(
            dateTimePlayedAdapter = ZonedDateTimeAdapter
        ),
        PlaylistEntityAdapter = PlaylistEntity.Adapter(
            dateTimeCreatedAdapter = ZonedDateTimeAdapter
        )
    )
}
