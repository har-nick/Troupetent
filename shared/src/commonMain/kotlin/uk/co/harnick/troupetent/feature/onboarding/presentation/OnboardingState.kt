package uk.co.harnick.troupetent.feature.onboarding.presentation

import uk.co.harnick.troupetent.feature.onboarding.domain.model.OnboardingPage

data class OnboardingState(
    val canGoBack: Boolean = false,
    val canGoForward: Boolean = true,
    val pagerIndex: Int = 0
) {
    val currentPage: OnboardingPage = OnboardingPage.entries[pagerIndex]
}
