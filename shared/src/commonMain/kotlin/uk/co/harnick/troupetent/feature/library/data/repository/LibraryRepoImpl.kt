package uk.co.harnick.troupetent.feature.library.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOneOrNull
import com.github.michaelbull.result.getOrThrow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onEach
import uk.co.harnick.bandkit.data.model.BandcampToken
import uk.co.harnick.bandkit.data.model.Track
import uk.co.harnick.bandkit.data.remote.api.BandKit
import uk.co.harnick.troupetent.Account
import uk.co.harnick.troupetent.LibraryItem
import uk.co.harnick.troupetent.LibrarySummary
import uk.co.harnick.troupetent.LocalStorage
import uk.co.harnick.troupetent.feature.library.domain.mappers.toLibraryItem
import uk.co.harnick.troupetent.feature.library.domain.repository.LibraryRepo
import java.time.ZonedDateTime
import kotlin.coroutines.CoroutineContext
import uk.co.harnick.bandkit.data.model.LibraryItem as BandKitItem
import uk.co.harnick.bandkit.data.model.LibrarySummary as BandKitSummary

class LibraryRepoImpl(db: LocalStorage) : LibraryRepo {
    private val itemQueries = db.library_itemQueries
    private val playerHistoryQueries = db.player_historyQueries
    private val summaryQueries = db.library_summaryQueries

    override suspend fun updateData(account: Account) {
        with(account) {
            BandKit
                .fetchLibraryItems(id, token)
                .getOrThrow()
                .let { writeData(id, it) }
        }
    }

    override fun loadData(
        ownerId: Long,
        callerContext: CoroutineContext
    ): Flow<List<LibraryItem>?> =
        itemQueries.load(ownerId)
            .asFlow()
            .mapToList(callerContext)
            .map { it.ifEmpty { null } }

    override fun writeData(ownerId: Long, data: List<BandKitItem>) {
        val mappedData = data.map { it.toLibraryItem(ownerId) }
        mappedData.forEach { item ->
            with(item) {
                itemQueries.save(
                    artist,
                    artId,
                    dateTimePurchased,
                    dateTimeReleased,
                    downloadLink,
                    favoriteTrackId,
                    id,
                    ownerId,
                    trackList,
                    title,
                    type
                )
            }
        }
    }

    override fun deleteData(ownerId: Long) = itemQueries.delete(ownerId)

    override suspend fun updateSummary(token: BandcampToken) {
        BandKit
            .fetchLibrarySummary(token)
            .getOrThrow()
            .let { writeSummary(it) }
    }

    override fun loadSummary(
        ownerId: Long,
        callerContext: CoroutineContext
    ): Flow<LibrarySummary?> =
        summaryQueries.load(ownerId)
            .asFlow()
            .mapToOneOrNull(callerContext)

    override fun writeSummary(summary: BandKitSummary) = with(summary) {
        summaryQueries.save(itemCount, ownerId)
    }

    override fun deleteSummary(ownerId: Long) = summaryQueries.delete(ownerId)

    override fun updatePlayerHistory(accountId: Long, track: Track) {
        val dateTimePlayed = ZonedDateTime.now()
        playerHistoryQueries.update(track.id, dateTimePlayed, accountId)
    }

    override fun clearPlayerHistory(accountId: Long) = playerHistoryQueries.drop(accountId)
}
