package uk.co.harnick.troupetent.core.util.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.TextUnit

@Composable
fun MeasureTextSize(
    text: String,
    style: TextStyle = MaterialTheme.typography.bodyLarge
): Pair<TextUnit, TextUnit> {
    val textMeasurer = rememberTextMeasurer()
    val (width, height) = textMeasurer.measure(text, style).size
    return with(LocalDensity.current) { Pair(width.toSp(), height.toSp()) }
}
