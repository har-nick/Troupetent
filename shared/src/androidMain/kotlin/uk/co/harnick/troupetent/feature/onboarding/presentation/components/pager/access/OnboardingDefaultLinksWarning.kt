package uk.co.harnick.troupetent.feature.onboarding.presentation.components.pager.access

import android.content.Intent
import android.net.Uri
import android.os.Build.VERSION_CODES.S
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.phonelink_setup_filled
import uk.co.harnick.troupetent.core.ui.presentation.InlineTextComponent
import uk.co.harnick.troupetent.core.ui.presentation.components.RowCard

@RequiresApi(S)
@Composable
fun OnboardingDefaultLinksWarning() {
    val localContext = LocalContext.current

    val intent = Intent(
        /* action = */ Settings.ACTION_APP_OPEN_BY_DEFAULT_SETTINGS,
        /* uri = */ Uri.parse("package:${localContext.packageName}")
    )

    val clickHereLink = InlineTextComponent(
        text = "default links",
        modifier = Modifier
            .clickable { localContext.startActivity(intent) }
            .pointerHoverIcon(PointerIcon.Hand)
    )

    val warning =
        "Bandcamp may send you a verification email. To sign in, you'll need to add Bandcamp to Troupetent's"

    val appendedWarning = buildAnnotatedString {
        append(warning)
        clickHereLink.append(this)
        append(".")
    }

    val mappedContent = mapOf(clickHereLink.inlineContent)

    RowCard(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        cardColors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        )
    ) {
        Icon(
            painter = painterResource(Res.drawable.phonelink_setup_filled),
            contentDescription = null
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            BasicText(
                text = appendedWarning,
                inlineContent = mappedContent,
                style = MaterialTheme.typography.bodyLarge.copy(color = LocalContentColor.current)
            )
        }
    }
}
