package uk.co.harnick.troupetent.feature.library.domain.repository

import kotlinx.coroutines.flow.Flow
import uk.co.harnick.bandkit.data.model.BandcampToken
import uk.co.harnick.bandkit.data.model.Track
import uk.co.harnick.troupetent.Account
import uk.co.harnick.troupetent.LibraryItem
import uk.co.harnick.troupetent.LibrarySummary
import kotlin.coroutines.CoroutineContext
import uk.co.harnick.bandkit.data.model.LibraryItem as BandKitItem
import uk.co.harnick.bandkit.data.model.LibrarySummary as BandKitSummary

interface LibraryRepo {
    suspend fun updateData(account: Account)
    fun loadData(ownerId: Long, callerContext: CoroutineContext): Flow<List<LibraryItem>?>
    fun writeData(ownerId: Long, data: List<BandKitItem>)
    fun deleteData(ownerId: Long)

    suspend fun updateSummary(token: BandcampToken)
    fun loadSummary(ownerId: Long, callerContext: CoroutineContext): Flow<LibrarySummary?>
    fun writeSummary(summary: BandKitSummary)
    fun deleteSummary(ownerId: Long)

    fun updatePlayerHistory(accountId: Long, track: Track)
    fun clearPlayerHistory(accountId: Long)
}
