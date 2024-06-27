package uk.co.harnick.troupetent.core.ui.presentation

import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import uk.co.harnick.troupetent.core.util.Random
import uk.co.harnick.troupetent.core.util.compose.MeasureTextSize

class InlineTextComponent(
    val text: String,
    private val modifier: Modifier = Modifier,
    val id: String = Random.string(),
    private val style: TextStyle? = null
) {
    @Composable
    private fun Component(): InlineTextContent {
        val clickableStyle = style ?: LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )
        val placeholderSize = MeasureTextSize(text, clickableStyle)

        return InlineTextContent(
            placeholder = Placeholder(
                width = placeholderSize.first,
                height = placeholderSize.second,
                placeholderVerticalAlign = PlaceholderVerticalAlign.Center
            ),
            children = {
                Text(text = text, modifier = modifier, style = clickableStyle)
            }
        )
    }

    val inlineContent: Pair<String, InlineTextContent>
        @Composable
        get() = Pair(id, Component())

    fun append(builder: AnnotatedString.Builder) = builder.appendInlineContent(id, text)
}
