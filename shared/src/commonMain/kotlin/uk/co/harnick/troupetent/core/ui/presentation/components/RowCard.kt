package uk.co.harnick.troupetent.core.ui.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RowCard(
    modifier: Modifier = Modifier,
    elevation: CardElevation = CardDefaults.cardElevation(),
    horizontalArrangement: Arrangement.Horizontal = spacedBy(12.dp),
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    cardColors: CardColors = CardDefaults.cardColors(),
    content: @Composable RowScope.() -> Unit
) {
    Card(modifier = modifier, colors = cardColors, elevation = elevation) {
        Row(
            modifier = Modifier.padding(all = 16.dp),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment,
            content = content
        )
    }
}
