package uk.co.harnick.troupetent.core.ui.presentation

import androidx.compose.runtime.Composable

@Composable
expect fun BackHandler(enabled: Boolean = true, onBack: () -> Unit)
