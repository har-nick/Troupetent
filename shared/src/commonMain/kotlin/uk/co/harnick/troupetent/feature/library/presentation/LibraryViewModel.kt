package uk.co.harnick.troupetent.feature.library.presentation

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import uk.co.harnick.bandkit.data.model.Track
import uk.co.harnick.troupetent.Account
import uk.co.harnick.troupetent.common.servicelocator.modules.IODispatcher
import uk.co.harnick.troupetent.core.ui.presentation.StatefulViewModel
import uk.co.harnick.troupetent.core.util.Return
import uk.co.harnick.troupetent.core.util.Return.InProgress
import uk.co.harnick.troupetent.feature.library.domain.repository.LibraryRepo
import uk.co.harnick.troupetent.feature.library.domain.usecase.LibraryUseCases
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent.UI.AddTrackToQueue
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent.UI.RefreshData
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent.UI.UpdateSorting
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent.VM

class LibraryViewModel(
    private val currentAccount: Account,
    private val ioDispatcher: IODispatcher,
    private val libraryRepo: LibraryRepo,
    private val libraryUseCases: LibraryUseCases
) : StatefulViewModel<LibraryState, LibraryEvent>(LibraryState()) {
    override fun onEvent(event: LibraryEvent) {
        when (event) {
            is VM -> {}
            is AddTrackToQueue -> queueTrack(event.track)
            is RefreshData -> syncLibrary()
            is UpdateSorting -> mutableState.update { it.copy(sorting = event.newSorting) }
        }
    }

    init {
        monitorLibrarySyncState()
        monitorLibraryData()
    }

    private fun queueTrack(track: Track) {

    }

    private fun syncLibrary() {
        mutableState.update { it.copy(libraryIsRefreshing = true) }
        libraryUseCases.monitorLibrarySyncState.forceSync(currentAccount.id)
    }

    private fun monitorLibraryData() {
        libraryRepo.loadData(currentAccount.id, vmContext)
            .onEach { data ->
                mutableState.update {
                    it.copy(libraryItems = data, libraryIsRefreshing = (data == null))
                }
            }
            .catch { error ->
                mutableState.update {
                    it.copy(error = error.message, libraryIsRefreshing = false)
                }
            }
            .launchIn(vmScope)
    }

    private fun monitorLibrarySyncState() {
        libraryUseCases.monitorLibrarySyncState(currentAccount, vmScope)
            .flowOn(ioDispatcher)
            .onEach { emission ->
                mutableState.update {
                    it.copy(error = (emission as? Return.Error)?.reason,)
                }
            }
            .catch { error ->
                mutableState.update {
                    it.copy(error = error.message, libraryIsRefreshing = false)
                }
            }
            .launchIn(vmScope)
    }
}
