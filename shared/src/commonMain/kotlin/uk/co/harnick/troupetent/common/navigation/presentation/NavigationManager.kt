package uk.co.harnick.troupetent.common.navigation.presentation

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.jetpack.ProvideNavigatorLifecycleKMPSupport
import cafe.adriel.voyager.navigator.Navigator
import uk.co.harnick.troupetent.common.navigation.domain.model.Destination.Library
import uk.co.harnick.troupetent.common.navigation.domain.model.Destination.Onboarding
import uk.co.harnick.troupetent.common.navigation.presentation.components.AtomicContextLeakFix
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator

@OptIn(ExperimentalVoyagerApi::class)
object NavigationManager {
    @Composable
    operator fun invoke(content: @Composable (Navigator) -> Unit) {
        val accountsState by ServiceLocator.viewModelModule.accountViewModel.state.collectAsState()
        val initialDestination by remember(accountsState.accountList) {
            derivedStateOf {
                if (accountsState.isLoadingAccounts) null
                else accountsState.currentAccount
                    ?.let { Library(it) }
                    ?: Onboarding
            }
        }

        initialDestination?.let { destination ->
            ProvideNavigatorLifecycleKMPSupport {
                Navigator(destination.screenProvider()) { navigator ->
                    AtomicContextLeakFix(navigator)

                    // Triggers login when OnboardingScreen retrieves a token
                    LaunchedEffect(destination) {
                        navigator.replaceAll(destination.screenProvider())
                    }

                    // Wrapping in a Surface avoids flashing backgrounds on transition
                    Surface { content(navigator) }
                }
            }
        }
    }
}
