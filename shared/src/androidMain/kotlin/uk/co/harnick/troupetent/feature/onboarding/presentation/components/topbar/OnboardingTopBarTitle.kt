package uk.co.harnick.troupetent.feature.onboarding.presentation.components.topbar

import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import kotlinx.coroutines.launch
import androidx.compose.animation.core.Animatable as FloatAnimatable

@Composable
fun OnboardingTopBarTitle(stagedTitle: String) {
    var title by remember { mutableStateOf(stagedTitle) }
    val alpha = remember { FloatAnimatable(1F) }
    val alphaTransitionScope = rememberCoroutineScope()

    fun transition() = alphaTransitionScope.launch {
        alpha.animateTo(0F, tween())
        title = stagedTitle
        alpha.animateTo(1F, tween())
    }

    var canAnimate by remember { mutableStateOf(false) }
    LaunchedEffect(stagedTitle) { if (canAnimate) transition() else canAnimate = true }

    Text(text = title, modifier = Modifier.alpha(alpha.value))
}
