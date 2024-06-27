package uk.co.harnick.troupetent.feature.library.presentation.components.tracklistmodal

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.harnick.bandkit.data.model.Track
import uk.co.harnick.troupetent.core.ui.presentation.Insets

// Used for queue, history, and playlist functionality
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackListModal(
    isVisible: Boolean,
    onDismiss: () -> Unit,
    trackList: List<Track> = listOf()
) {
    @Composable
    fun noHistoryNotif() {
        Column(
            modifier = Modifier
                .padding(bottom = Insets.statusBar)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
        ) {
            Text(text = "ᕕ( ᐛ )ᕗ", style = MaterialTheme.typography.headlineLarge)
            Text(text = "Your history is empty!", style = MaterialTheme.typography.titleLarge)
        }
    }

    val state = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically { offset -> offset / 2 },
        exit = slideOutVertically { offset -> offset / 2 }
    ) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            modifier = Modifier
                .padding(top = Insets.statusBar / 2)
                .fillMaxHeight(),
            sheetState = state,
            windowInsets = Insets.none,
            content = {
                if (trackList.isEmpty()) noHistoryNotif()
                else LazyColumn {
                    items(trackList) { it.ToTrackListModalItem() }
                }
            }
        )
    }
}
