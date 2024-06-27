package uk.co.harnick.troupetent.feature.library.presentation.components.playerwidget

import androidx.compose.runtime.Composable
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent
import uk.co.harnick.troupetent.feature.library.presentation.LibraryState

@Composable
fun FloatingPlayerWidget(
    params: LibraryState.PlayerWidgetParams,
    libraryEvent: (LibraryEvent) -> Unit
) {
    FloatingPlayerContainer(isVisible = params.isVisible) {
        FloatingPlayerFrame(libraryEvent) {
            params.currentTrack?.let { WidgetAlbumIcon(it.artId) }
        }
    }
}
