package uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager.welcome

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingWelcomePage() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = spacedBy(18.dp)
    ) {
        Text(text = "WELCOME BACKGROUND NOTICE")
        OnboardingSourceCodeNotice()
        OnboardingBugNotice()
    }
}
