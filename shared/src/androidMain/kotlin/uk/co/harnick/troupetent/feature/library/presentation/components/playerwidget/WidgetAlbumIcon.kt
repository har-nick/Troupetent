package uk.co.harnick.troupetent.feature.library.presentation.components.playerwidget

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import uk.co.harnick.bandkit.data.model.AlbumArtUrl

@Composable
fun WidgetAlbumIcon(imageId: Long) {
    val imageLink by remember { derivedStateOf { "${AlbumArtUrl(imageId)}" } }

    Crossfade(targetState = imageLink) { link ->
        KamelImage(
            resource = asyncPainterResource(link),
            contentDescription = null,
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .aspectRatio(1F)
                .fillMaxSize(),
            animationSpec = tween()
        )
    }
}
