package uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.bug_report_filled
import uk.co.harnick.troupetent.core.ui.presentation.components.RowCard

@Composable
fun OnboardingBugNotice() {
    RowCard(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(Res.drawable.bug_report_filled), contentDescription = null)
        Text(text = "BUG NOTICE")
    }
}
