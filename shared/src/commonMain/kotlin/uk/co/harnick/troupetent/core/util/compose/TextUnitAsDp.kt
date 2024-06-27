package uk.co.harnick.troupetent.core.util.compose

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val TextStyle.dp: Dp
    get() = this.fontSize.value.dp
