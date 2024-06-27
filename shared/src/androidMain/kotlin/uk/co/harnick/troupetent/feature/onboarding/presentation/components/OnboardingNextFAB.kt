package uk.co.harnick.troupetent.feature.onboarding.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.arrow_back
import uk.co.harnick.troupetent.feature.onboarding.presentation.OnboardingEvent
import uk.co.harnick.troupetent.feature.onboarding.presentation.OnboardingEvent.PagerInteraction.Forward

@Composable
fun OnboardingNextFAB(canGoForward: Boolean, onEvent: (OnboardingEvent) -> Unit) {
    AnimatedVisibility(
        visible = canGoForward,
        enter = fadeIn(tween(delayMillis = 300)),
        exit = fadeOut(snap())
    ) {
        FloatingActionButton(
            onClick = { onEvent(Forward) }
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp),
                horizontalArrangement = spacedBy(8.dp, CenterHorizontally),
                verticalAlignment = CenterVertically
            ) {
                Text("NEXT PAGE")
                Icon(
                    painter = painterResource(Res.drawable.arrow_back),
                    contentDescription = "Go to the next page",
                    modifier = Modifier.rotate(180F)
                )
            }
        }
    }
}
