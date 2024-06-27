package uk.co.harnick.troupetent.common.navigation.presentation.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun CrossfadeIcon(
    icon: DrawableResource,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
    size: Dp? = null,
    animationSpec: FiniteAnimationSpec<Float> = spring()
) {
    Crossfade(targetState = icon, animationSpec = animationSpec) { iconState ->
        Icon(
            painter = painterResource(iconState),
            contentDescription = contentDescription,
            modifier = size?.let { Modifier.size(it).then(modifier) } ?: modifier,
            tint = tint
        )
    }
}
