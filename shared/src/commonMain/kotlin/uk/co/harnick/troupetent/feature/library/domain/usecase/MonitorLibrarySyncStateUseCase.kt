package uk.co.harnick.troupetent.feature.library.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import uk.co.harnick.troupetent.Account
import uk.co.harnick.troupetent.core.util.Return
import uk.co.harnick.troupetent.core.util.Return.InProgress.Fetching
import uk.co.harnick.troupetent.feature.library.domain.repository.LibraryRepo

class MonitorLibrarySyncStateUseCase(private val libraryRepo: LibraryRepo) {
    fun forceSync(accountId: Long) {
        libraryRepo.deleteData(accountId)
        libraryRepo.deleteSummary(accountId)
    }

    operator fun invoke(account: Account, callerScope: CoroutineScope): Flow<Return<Unit>?> {
        val syncState = MutableStateFlow<Return<Unit>?>(null)

        libraryRepo.loadSummary(account.id, callerScope.coroutineContext)
            .onStart {
                syncState.update { Fetching("Updating library data") }
                libraryRepo.updateSummary(account.token)
            }
            .onEach { summary ->
                summary
                    ?.let { libraryRepo.updateData(account) }
                    ?: run { libraryRepo.updateSummary(account.token) }
            }
            .filterNotNull()
            .distinctUntilChanged()
            .onEach { libraryRepo.updateData(account) }
            .launchIn(callerScope)

        return syncState.asStateFlow()
    }
}
