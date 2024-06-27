package uk.co.harnick.troupetent.feature.onboarding.presentation.components.topbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.settings_filled
import troupetent.shared.generated.resources.token_filled
import uk.co.harnick.troupetent.common.navigation.domain.model.Destination
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountEvent
import uk.co.harnick.troupetent.core.ui.presentation.components.NavigationBackArrow
import uk.co.harnick.troupetent.feature.onboarding.domain.model.OnboardingPage
import uk.co.harnick.troupetent.feature.onboarding.domain.model.OnboardingPage.Access
import uk.co.harnick.troupetent.feature.onboarding.presentation.OnboardingEvent
import uk.co.harnick.troupetent.feature.onboarding.presentation.OnboardingEvent.PagerInteraction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingTopBar(
    canGoBack: Boolean,
    currentPage: OnboardingPage,
    accountEvent: (AccountEvent) -> Unit,
    onboardingEvent: (OnboardingEvent) -> Unit
) {
    val navigator = LocalNavigator.currentOrThrow

    MediumTopAppBar(
        title = { OnboardingTopBarTitle(stagedTitle = currentPage.title) },
        navigationIcon = {
            AnimatedVisibility(
                visible = canGoBack,
                enter = fadeIn(tween()),
                exit = fadeOut(tween())
            ) {
                NavigationBackArrow(onBack = { onboardingEvent(PagerInteraction.Back) })
            }
        },
        actions = {
            AnimatedVisibility(
                visible = (currentPage == Access),
                enter = fadeIn(tween()),
                exit = fadeOut(tween())
            ) {
                IconButton(
                    onClick = { accountEvent(AccountEvent.ToggleTokenDialog) },
                    content = {
                        Icon(
                            painter = painterResource(Res.drawable.token_filled),
                            contentDescription = "Login with your Bandcamp token"
                        )
                    }
                )
            }

            IconButton(
                onClick = {
                    navigator.push(Destination.Settings.screenProvider())
                },
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.settings_filled),
                        contentDescription = "Travel to settings"
                    )
                }
            )
        }
    )
}
