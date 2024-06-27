package uk.co.harnick.troupetent.feature.library.presentation

import uk.co.harnick.bandkit.data.model.Track
import uk.co.harnick.troupetent.LibraryItem
import uk.co.harnick.troupetent.feature.library.domain.model.LibrarySorting

data class LibraryState(
    val error: String? = null,
    val history: List<Track> = listOf(),
    val itemQueue: List<Track> = listOf(),
    val libraryItems: List<LibraryItem>? = null,
    val libraryIsRefreshing: Boolean = false,
    val queueIndex: Int = 0,
    val sorting: LibrarySorting = LibrarySorting()
) {
    val currentTrack: Track? = itemQueue.getOrNull(queueIndex)

    inner class ItemGridParams {
        val hasQueuedTracks: Boolean = itemQueue.isNotEmpty()
        val libraryItems: List<LibraryItem>? = this@LibraryState.libraryItems
    }

    inner class PlayerWidgetParams {
        val itemQueue: List<Track> = this@LibraryState.itemQueue
        val currentTrack: Track? = this@LibraryState.currentTrack
        val isVisible: Boolean = currentTrack != null
    }

    val itemGridParams = ItemGridParams()
    val playerWidgetParams = PlayerWidgetParams()
}
