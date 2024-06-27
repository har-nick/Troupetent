package uk.co.harnick.troupetent.core.ui.presentation

import androidx.compose.ui.platform.UriHandler
import uk.co.harnick.troupetent.core.util.Desktop
import java.net.URI

object DesktopUriHandler : UriHandler {
    override fun openUri(uri: String) = Desktop.browse(URI(uri))
}
