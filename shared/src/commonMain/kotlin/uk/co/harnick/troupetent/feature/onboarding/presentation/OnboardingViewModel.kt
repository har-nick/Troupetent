package uk.co.harnick.troupetent.feature.onboarding.presentation

import kotlinx.coroutines.flow.update
import uk.co.harnick.troupetent.core.ui.presentation.StatefulViewModel
import uk.co.harnick.troupetent.feature.onboarding.domain.model.OnboardingPage
import uk.co.harnick.troupetent.feature.onboarding.presentation.OnboardingEvent.PagerInteraction

class OnboardingViewModel : StatefulViewModel<OnboardingState, OnboardingEvent>(OnboardingState()) {
    private val pages = OnboardingPage.entries

    override fun onEvent(event: OnboardingEvent) = when (event) {
        is PagerInteraction -> {
            val maxPages = pages.size
            val destinationIndex = (state.value.pagerIndex + event.stepValue).coerceAtMost(maxPages)
            val destinationPage = pages[destinationIndex]
            val canGoBack = destinationPage != pages.first()
            val canGoForward = destinationPage != pages.last()

            mutableState.update {
                it.copy(
                    canGoBack = canGoBack,
                    canGoForward = canGoForward,
                    pagerIndex = destinationIndex
                )
            }
        }
    }
}
