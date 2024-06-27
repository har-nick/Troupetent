package uk.co.harnick.troupetent.feature.library.presentation.components.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import uk.co.harnick.bandkit.data.model.ImageSize
import uk.co.harnick.bandkit.data.model.ProfileImageUrl

@Composable
fun LibraryAvatar(name: String, avatarId: Long?) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(42.dp)
            .clickable { },
        contentAlignment = Center
    ) {
        avatarId
            ?.let {
                KamelImage(
                    resource = asyncPainterResource(
                        "${
                            ProfileImageUrl(
                                avatarId,
                                ImageSize.Small
                            )
                        }"
                    ),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            ?: Text(
                text = "${name.first()}",
                modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.headlineMedium
            )
    }
}
