package uk.co.harnick.troupetent.feature.library.presentation.components.playerwidget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import uk.co.harnick.troupetent.core.ui.presentation.Elevation
import uk.co.harnick.troupetent.core.ui.presentation.Insets
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent

@Composable
fun FloatingPlayerFrame(
    libraryEvent: (LibraryEvent) -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .clip(MaterialTheme.shapes.small)
            .padding(start = 8.dp, end = 8.dp, bottom = Insets.navigationBar + 4.dp)
            .shadow(elevation = Elevation.Level3.dp, shape = MaterialTheme.shapes.small)
            .height(72.dp)
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                MaterialTheme.shapes.small
            )
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = content
    )
}
