package uk.co.harnick.troupetent.common.navigation.presentation.components

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator

// See adrielcafe/voyager/issues/112
// Untested if this works for nested navigators
@Composable
expect fun AtomicContextLeakFix(navigator: Navigator)
