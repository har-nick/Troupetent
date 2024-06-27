package uk.co.harnick.troupetent.feature.library.presentation.components.library

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import uk.co.harnick.bandkit.data.model.AlbumArtUrl
import uk.co.harnick.troupetent.LibraryItem
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent.UI.AddTrackToQueue

@Composable
fun LibraryItem(
    libraryEvent: (LibraryEvent) -> Unit,
    item: LibraryItem
) {
    val settingsState by ServiceLocator.viewModelModule.settingsViewModel.state.collectAsState()
    val artQuality by remember(settingsState) {
        derivedStateOf { settingsState.displaySettings.artQuality.value }
    }
    val artUrl by remember(item, artQuality) {
        derivedStateOf { "${AlbumArtUrl(item.artId, artQuality.apiRef)}" }
    }

    var contextMenuIsVisible by remember { mutableStateOf(false) }
    var contextMenuOffset by remember { mutableStateOf(DpOffset(0.dp, 0.dp)) }

    Card(
        Modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = { offset ->
                        contextMenuIsVisible = true
                        contextMenuOffset = DpOffset(x = offset.x.toDp(), y = offset.x.toDp())
                    }
                )
            }
            .clickable {
                item.trackList?.forEach { libraryEvent(AddTrackToQueue(it)) }
            }
    ) {
        KamelImage(
            resource = asyncPainterResource(artUrl),
            contentDescription = null,
            modifier = Modifier.aspectRatio(1F)
        )
        Column(
            modifier = Modifier.padding(all = 6.dp)
        ) {
            Text(
                text = item.title,
                fontWeight = SemiBold,
                overflow = Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = item.artist.name,
                overflow = Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
