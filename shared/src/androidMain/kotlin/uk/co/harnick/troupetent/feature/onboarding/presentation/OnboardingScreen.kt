package uk.co.harnick.troupetent.feature.onboarding.presentation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator
import uk.co.harnick.troupetent.core.account.bandcamp.domain.model.AccountAccessMethod.Login
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccessScreen
import uk.co.harnick.troupetent.core.util.clear
import uk.co.harnick.troupetent.feature.onboarding.domain.model.OnboardingPage
import uk.co.harnick.troupetent.feature.onboarding.presentation.OnboardingEvent.PagerInteraction
import uk.co.harnick.troupetent.feature.onboarding.presentation.components.OnboardingNextFAB
import uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager.OnboardingPager
import uk.co.harnick.troupetent.feature.onboarding.presentation.components.topbar.OnboardingTopBar

actual object OnboardingScreen : Screen {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val localContext = LocalContext.current
        val activity = localContext as Activity
        val navigator = LocalNavigator.currentOrThrow

        val onboardingViewModel = rememberScreenModel { OnboardingViewModel() }
        val onboardingState by onboardingViewModel.state.collectAsState()
        val canGoBack by remember { derivedStateOf { onboardingState.canGoBack } }
        val canGoForward by remember { derivedStateOf { onboardingState.canGoForward } }
        val currentPage = onboardingState.currentPage
        val onboardingEvent = onboardingViewModel::onEvent

        val accountViewModel = ServiceLocator.viewModelModule.accountViewModel
        val accountEvent = accountViewModel::onEvent

        LaunchedEffect(activity.intent.dataString) {
            val loginVerificationUrl = activity.intent.dataString

            loginVerificationUrl?.let {
                // Prevent app from using intent if resumed
                activity.intent.clear()
                navigator.push(AccessScreen(Login, loginVerificationUrl))
            }
        }

        BackHandler(enabled = canGoBack, onBack = { onboardingEvent(PagerInteraction.Back) })

        val pagerState = rememberPagerState(pageCount = { OnboardingPage.entries.size })
        LaunchedEffect(onboardingState.pagerIndex) {
            pagerState.animateScrollToPage(onboardingState.pagerIndex, animationSpec = tween())
        }

        Scaffold(
            topBar = { OnboardingTopBar(canGoBack, currentPage, accountEvent, onboardingEvent) },
            floatingActionButton = { OnboardingNextFAB(canGoForward, onboardingEvent) },
            content = { scaffoldPadding -> OnboardingPager(scaffoldPadding, pagerState) }
        )
    }
}
