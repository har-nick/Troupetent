package uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager.access.OnboardingAccessPage
import uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager.welcome.OnboardingWelcomePage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPager(scaffoldPadding: PaddingValues, state: PagerState) {
    HorizontalPager(
        state = state,
        modifier = Modifier.padding(scaffoldPadding),
        pageSpacing = 20.dp,
        verticalAlignment = Top,
        userScrollEnabled = false
    ) { currentPage ->
        when (currentPage) {
            0 -> OnboardingWelcomePage()
            1 -> OnboardingAccessPage()
        }
    }
}
