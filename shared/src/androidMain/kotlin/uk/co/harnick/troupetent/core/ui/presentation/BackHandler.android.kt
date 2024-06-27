package uk.co.harnick.troupetent.core.ui.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
actual fun BackHandler(enabled: Boolean, onBack: () -> Unit) = BackHandler(enabled, onBack)
