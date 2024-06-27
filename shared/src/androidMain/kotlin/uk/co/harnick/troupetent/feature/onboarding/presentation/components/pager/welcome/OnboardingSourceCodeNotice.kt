package uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager.welcome

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.code
import uk.co.harnick.troupetent.core.ui.presentation.InlineTextComponent
import uk.co.harnick.troupetent.core.ui.presentation.components.RowCard

@Composable
fun OnboardingSourceCodeNotice() {
    val uriHandler = LocalUriHandler.current

    val githubRepoLink = InlineTextComponent(
        text = "SOURCE CODE PROMPT",
        modifier = Modifier
            .clickable { uriHandler.openUri("https://github.com/har-nick/troupetent") }
            .pointerHoverIcon(PointerIcon.Hand)
    )

    val noticeWithPrompt = buildAnnotatedString {
        append("SOURCE CODE NOTICE")
        githubRepoLink.append(this)
        append(".")
    }

    val mappedContent = mapOf(githubRepoLink.inlineContent)

    RowCard(horizontalArrangement = spacedBy(12.dp), verticalAlignment = CenterVertically) {
        Icon(painter = painterResource(Res.drawable.code), contentDescription = null)
        BasicText(
            text = noticeWithPrompt,
            inlineContent = mappedContent,
            style = MaterialTheme.typography.bodyLarge.copy(color = LocalContentColor.current)
        )
    }
}
