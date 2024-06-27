package uk.co.harnick.troupetent.feature.library.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.harnick.troupetent.feature.library.presentation.modifiers.scrollingTabIndicatorOffset

@Composable
fun ScrollingTabIndicator(
    tabPosition: TabPosition,
    scrollOffset: Float,
    width: Dp = tabPosition.contentWidth,
    height: Dp = 3.0.dp,
    color: Color = MaterialTheme.colorScheme.primary,
    shape: Shape = RoundedCornerShape(3.0.dp)
) {
    Spacer(
        Modifier
            .scrollingTabIndicatorOffset(tabPosition, scrollOffset)
            .requiredHeight(height)
            .requiredWidth(width)
            .background(color, shape)
    )
}
