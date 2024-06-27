package uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager.access

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.harnick.troupetent.core.account.bandcamp.domain.model.AccountAccessMethod.Login
import uk.co.harnick.troupetent.core.account.bandcamp.domain.model.AccountAccessMethod.Register
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountEvent
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountEvent.AccessMethodInteraction.SetAccessMethod

@Composable
fun OnboardingAccessButtons(accountEvent: (AccountEvent) -> Unit, isLoggingIn: Boolean) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(
            onClick = { accountEvent(SetAccessMethod(Login)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoggingIn,
            contentPadding = PaddingValues(vertical = 14.dp),
            content = { Text(text = "Login") }
        )
        OutlinedButton(
            onClick = { accountEvent(SetAccessMethod(Register)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoggingIn,
            contentPadding = PaddingValues(vertical = 14.dp),
            content = { Text(text = "Register") }
        )
    }
}
