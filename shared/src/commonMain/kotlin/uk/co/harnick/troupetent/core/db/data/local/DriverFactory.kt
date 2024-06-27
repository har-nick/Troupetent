package uk.co.harnick.troupetent.core.db.data.local

import app.cash.sqldelight.adapter.primitive.IntColumnAdapter
import app.cash.sqldelight.db.SqlDriver
import uk.co.harnick.troupetent.Account
import uk.co.harnick.troupetent.DisplaySettingsEntity
import uk.co.harnick.troupetent.GeneralSettingsEntity
import uk.co.harnick.troupetent.LibraryItem
import uk.co.harnick.troupetent.LibrarySummary
import uk.co.harnick.troupetent.LocalStorage
import uk.co.harnick.troupetent.PlayerHistory
import uk.co.harnick.troupetent.Playlist
import uk.co.harnick.troupetent.core.account.bandcamp.data.local.adapters.BandcampTokenAdapter
import uk.co.harnick.troupetent.core.db.data.local.adapters.EnumToStringAdapter
import uk.co.harnick.troupetent.core.db.data.local.adapters.GenericToStringAdapter
import uk.co.harnick.troupetent.core.db.data.local.adapters.ZonedDateTimeAdapter
import uk.co.harnick.troupetent.core.settings.data.local.adapters.BooleanSettingAdapter
import uk.co.harnick.troupetent.core.settings.data.local.adapters.EnumSettingAdapter
import uk.co.harnick.troupetent.core.settings.data.local.adapters.SeedColorSettingAdapter

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createLocalStorage(driverFactory: DriverFactory): LocalStorage {
    val driver = driverFactory.createDriver()
    return LocalStorage(
        driver = driver,
        AccountAdapter = Account.Adapter(tokenAdapter = BandcampTokenAdapter),
        DisplaySettingsEntityAdapter = DisplaySettingsEntity.Adapter(
            artQualityAdapter = EnumSettingAdapter(),
            materialYouAdapter = BooleanSettingAdapter(),
            materialYouIshAdapter = BooleanSettingAdapter(),
            paletteAdapter = EnumSettingAdapter(),
            seedColorAdapter = SeedColorSettingAdapter,
            themeAdapter = EnumSettingAdapter()
        ),
        GeneralSettingsEntityAdapter = GeneralSettingsEntity.Adapter(
            languageAdapter = EnumSettingAdapter()
        ),
        LibraryItemAdapter = LibraryItem.Adapter(
            artistAdapter = GenericToStringAdapter(),
            dateTimeReleasedAdapter = ZonedDateTimeAdapter,
            dateTimePurchasedAdapter = ZonedDateTimeAdapter,
            trackListAdapter = GenericToStringAdapter(),
            typeAdapter = EnumToStringAdapter()
        ),
        LibrarySummaryAdapter = LibrarySummary.Adapter(
            itemCountAdapter = IntColumnAdapter
        ),
        PlayerHistoryAdapter = PlayerHistory.Adapter(
            dateTimePlayedAdapter = ZonedDateTimeAdapter
        ),
        PlaylistAdapter = Playlist.Adapter(
            dateTimeCreatedAdapter = ZonedDateTimeAdapter,
            trackListAdapter = GenericToStringAdapter()
        )
    )
}
