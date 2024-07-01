package uk.co.harnick.troupetent.core.ui.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Insets {
    val displayCutout: Dp
        @Composable
        get() = WindowInsets.displayCutout.asPaddingValues().calculateTopPadding()

    val ime: Dp
        @Composable
        get() = WindowInsets.ime.asPaddingValues().calculateBottomPadding()

    val none: WindowInsets = WindowInsets(left = 0.dp, top = 0.dp, right = 0.dp, bottom = 0.dp)

    val navigationBar: Dp
        @Composable
        get() = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    val statusBar: Dp
        @Composable
        get() = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()

    val systemBars: PaddingValues
        @Composable
        get() = PaddingValues(top = statusBar, bottom = navigationBar)
}
