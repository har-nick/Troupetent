package uk.co.harnick.troupetent.common.navigation.presentation.components.expandablenavrail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.snap
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Hand
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uk.co.harnick.troupetent.common.navigation.domain.model.Destination
import uk.co.harnick.troupetent.common.navigation.presentation.components.CrossfadeIcon

@Composable
fun ExpandableRailItem(
    destination: Destination,
    sheetExpanded: Boolean,
    expansionFinished: Boolean
) {
    val navigator = LocalNavigator.currentOrThrow
    val currentItem = navigator.lastItem

    val isActive by remember(currentItem) { mutableStateOf(destination == currentItem) }
    val icon by remember(isActive) {
        derivedStateOf { if (isActive) destination.icon?.active else destination.icon?.inactive }
    }
    val backgroundColor by animateColorAsState(
        targetValue = when (isActive) {
            true -> MaterialTheme.colorScheme.secondaryContainer
            false -> MaterialTheme.colorScheme.surface
        }
    )
    val foregroundColor by animateColorAsState(
        targetValue = when (isActive) {
            true -> MaterialTheme.colorScheme.onSecondaryContainer
            false -> MaterialTheme.colorScheme.onSurface
        }
    )

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .height(56.dp)
            .fillMaxWidth()
            .background(backgroundColor)
            .clickable(enabled = !isActive) { navigator.replaceAll(destination.screenProvider()) }
            .pointerHoverIcon(Hand)
            .padding(horizontal = 16.dp),
        contentAlignment = CenterStart
    ) {
        icon?.let { CrossfadeIcon(it, tint = foregroundColor) }

        destination.label.let {
            AnimatedVisibility(
                visible = sheetExpanded && expansionFinished,
                modifier = Modifier.align(Center),
                enter = fadeIn(),
                exit = fadeOut(snap()),
                content = {
                    Text(text = it, maxLines = 1, style = MaterialTheme.typography.labelLarge)
                }
            )
        }
    }
}
