package uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager.access

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.R
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccessScreen

@Preview
@Composable
fun OnboardingAccessPage() {
    val navigator = LocalNavigator.currentOrThrow

    val accountViewModel = ServiceLocator.viewModelModule.accountViewModel
    val accountState by accountViewModel.state.collectAsState()
    val accountEvent = accountViewModel::onEvent

    LaunchedEffect(accountState.accessIntent) {
        accountState.accessIntent?.let { navigator.push(AccessScreen(it)) }
    }

    OnboardingAccessTokenDialog(
        accountState.tokenDialogVisible,
        accountState.isLoggingIn,
        accountEvent
    )

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1F),
            verticalArrangement = spacedBy(18.dp)
        ) {
            item { OnboardingAccountRequirementCard() }
            item { OnboardingTokenExplanationCard() }
            if (SDK_INT > R) item { OnboardingDefaultLinksWarning() }
        }
        OnboardingAccessButtons(accountEvent, accountState.isLoggingIn)
    }
}
