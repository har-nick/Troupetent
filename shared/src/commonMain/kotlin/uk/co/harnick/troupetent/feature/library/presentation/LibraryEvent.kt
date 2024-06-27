package uk.co.harnick.troupetent.feature.library.presentation

import uk.co.harnick.bandkit.data.model.Track
import uk.co.harnick.troupetent.feature.library.domain.model.LibrarySorting

sealed interface LibraryEvent {
    sealed interface UI : LibraryEvent {
        class AddTrackToQueue(val track: Track) : UI

        data object RefreshData : UI

        sealed class UpdateSorting(val newSorting: LibrarySorting) : UI {
            class UpdateOrder(oldSorting: LibrarySorting) : UpdateSorting(
                newSorting = oldSorting.copy(order = oldSorting.order.step())
            )

            class UpdateType(oldSorting: LibrarySorting) : UpdateSorting(
                newSorting = oldSorting.copy(type = oldSorting.type.step())
            )
        }
    }

    sealed interface VM : LibraryEvent {

    }
}
