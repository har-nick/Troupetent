package uk.co.harnick.troupetent.feature.library.presentation.modifiers

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun Modifier.scrollingTabIndicatorOffset(
    currentTabPosition: TabPosition,
    scrollOffset: Float
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "scrollingTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val pronouncedOffset by remember(scrollOffset) {
        derivedStateOf { (scrollOffset * 100).roundToInt() }
    }
    val currentTabWidth by animateDpAsState(
        targetValue = currentTabPosition.width,
        animationSpec = tween(easing = LinearEasing)
    )
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left + pronouncedOffset.dp,
        animationSpec = spring()
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}
