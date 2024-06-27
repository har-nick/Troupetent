package uk.co.harnick.troupetent.feature.library.presentation.components.tracklistmodal

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import uk.co.harnick.bandkit.data.model.AlbumArtUrl
import uk.co.harnick.bandkit.data.model.Track
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator

@Composable
fun Track.ToTrackListModalItem() {
    val settingsState by ServiceLocator.viewModelModule.settingsViewModel.state.collectAsState()
    val artQuality by remember(settingsState) {
        derivedStateOf { settingsState.displaySettings.artQuality.value }
    }
    val artUrl by remember {
        derivedStateOf { "${AlbumArtUrl(artId, artQuality.apiRef)}" }
    }

    ListItem(
        headlineContent = { Text(title) },
        leadingContent = {
            KamelImage(
                resource = asyncPainterResource(artUrl),
                contentDescription = null,
                modifier = Modifier.aspectRatio(1F),
                animationSpec = tween()
            )
        }
    )
}
