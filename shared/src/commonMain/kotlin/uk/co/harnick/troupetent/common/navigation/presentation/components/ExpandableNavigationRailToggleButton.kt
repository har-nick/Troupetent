package uk.co.harnick.troupetent.common.navigation.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import uk.co.harnick.troupetent.core.design.Design
import uk.co.harnick.troupetent.core.ui.presentation.components.button.ToggleButton

@Composable
fun ExpandableNavigationRailToggleButton(
    isExpanded: Boolean,
    onClick: () -> Unit
) {
    ToggleButton(
        isEnabled = isExpanded,
        onClick = { onClick() }
    ) {
        val iconRotation by animateFloatAsState(
            targetValue = if (isExpanded) 180F else 0F,
            animationSpec = tween()
        )

        Icon(
            imageVector = Design.icons.menuOpen.filled,
            contentDescription = "${if (isExpanded) "Shrink" else "Expand"} the navigation menu.",
            modifier = Modifier.rotate(iconRotation)
        )
    }
}