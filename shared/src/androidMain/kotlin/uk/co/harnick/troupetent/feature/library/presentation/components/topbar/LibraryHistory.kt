package uk.co.harnick.troupetent.feature.library.presentation.components.topbar

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.history
import uk.co.harnick.bandkit.data.model.Track
import uk.co.harnick.troupetent.feature.library.presentation.components.tracklistmodal.TrackListModal

@Composable
fun LibraryHistory(history: List<Track>) {
    var modalVisible by remember { mutableStateOf(false) }

    IconButton(
        onClick = { modalVisible = true },
        content = {
            Icon(
                painter = painterResource(Res.drawable.history),
                contentDescription = null
            )
        }
    )

    TrackListModal(
        isVisible = modalVisible,
        onDismiss = { modalVisible = false },
        trackList = history
    )
}
