package uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager.access

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.token_filled
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountEvent

@Composable
fun OnboardingAccessTokenDialog(
    visible: Boolean,
    isLoggingIn: Boolean,
    accountEvent: (AccountEvent) -> Unit
) {
    var tokenFieldValue by remember { mutableStateOf("") }

    AnimatedVisibility(visible = visible, enter = fadeIn(), exit = fadeOut()) {
        AlertDialog(
            onDismissRequest = { accountEvent(AccountEvent.ToggleTokenDialog) },
            confirmButton = {
                TextButton(
                    onClick = { accountEvent(AccountEvent.Login(tokenFieldValue)) },
                    enabled = !isLoggingIn && tokenFieldValue.isNotBlank(),
                    content = { Text("Confirm") }
                )
            },
            dismissButton = {
                TextButton(
                    onClick = { accountEvent(AccountEvent.ToggleTokenDialog) },
                    enabled = !isLoggingIn,
                    content = { Text("Dismiss") }
                )
            },
            icon = {
                Icon(
                    painter = painterResource(Res.drawable.token_filled),
                    contentDescription = null
                )
            },
            title = { Text(text = "Token Login") },
            text = {
                TextField(
                    value = tokenFieldValue,
                    onValueChange = { newValue -> tokenFieldValue = newValue },
                    enabled = !isLoggingIn,
                    label = { Text(text = "Token") },
                    singleLine = true
                )
            }
        )
    }
}
