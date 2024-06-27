package uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager.access

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import uk.co.harnick.troupetent.core.ui.presentation.components.RowCard

@Composable
fun OnboardingAccountRequirementCard() {
    RowCard(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Icon(imageVector = Icons.Default.Person, contentDescription = null)
        Text(text = "ACCESS EXPLANATION")
    }
}
