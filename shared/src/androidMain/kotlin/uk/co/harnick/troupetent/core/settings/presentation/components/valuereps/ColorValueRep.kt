package uk.co.harnick.troupetent.core.settings.presentation.components.valuereps

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorValueRep(value: Color, onUpdate: (Color) -> Unit) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(48.dp)
            .background(value)
            .clickable {  }
    )
}
