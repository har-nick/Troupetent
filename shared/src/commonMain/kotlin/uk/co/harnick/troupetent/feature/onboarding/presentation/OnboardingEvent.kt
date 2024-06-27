package uk.co.harnick.troupetent.feature.onboarding.presentation

sealed interface OnboardingEvent {
    sealed class PagerInteraction(val stepValue: Int) : OnboardingEvent {
        data object Back : PagerInteraction(stepValue = -1)
        data object Forward : PagerInteraction(stepValue = +1)
    }
}
