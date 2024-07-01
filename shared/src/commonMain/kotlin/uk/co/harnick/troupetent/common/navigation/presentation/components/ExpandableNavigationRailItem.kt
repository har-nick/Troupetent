package uk.co.harnick.troupetent.common.navigation.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import uk.co.harnick.troupetent.core.design.Design

@Composable
fun ExpandableNavigationRailItem(
    isExpanded: Boolean,
    isSelected: Boolean,
    onNavigate: () -> Unit,
    isEnabled: Boolean = true,
    content: @Composable () -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) Design.colors.accent else Color.Transparent
    )
    val foregroundColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
    )

    val minWidth = 60.dp
    val iconSize = 24.dp
    val centerPadding = (minWidth - iconSize) / 2
    val width by animateDpAsState(
        targetValue = if (isExpanded) 200.dp else minWidth,
        animationSpec = tween()
    )

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .width(width)
            .height(minWidth)
            .background(backgroundColor)
            .clickable(isEnabled) { onNavigate() }
            .pointerHoverIcon(PointerIcon.Hand)
            .padding(centerPadding),
        contentAlignment = Alignment.CenterStart
    ) {
        // TODO: Migrate content
        content()

//        Icon(
//            painter = painterResource(if (isSelected) icon.outlined else icon.filled),
//            contentDescription = "",
//            modifier = Modifier.padding(start = centerPadding),
//            tint = foregroundColor
//        )
//
//        AnimatedVisibility(
//            visible = isExpanded,
//            enter = fadeIn(tween(delayMillis = 100)),
//            exit = fadeOut(snap())
//        ) {
//            Text(
//                text = label,
//                modifier = Modifier.fillMaxWidth(),
//                color = foregroundColor,
//                textAlign = TextAlign.Center,
//                maxLines = 1,
//                style = Design.typography.titleMedium
//            )
//        }
    }
}
