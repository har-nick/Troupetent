package uk.co.harnick.troupetent.core.settings.domain.model.general

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.harnick.troupetent.core.design.Design
import uk.co.harnick.troupetent.core.settings.domain.model.Setting

class WriteMetadataToDownloadsSetting(
    override val value: Boolean = true
) : Setting<Boolean>(
    value = value,
    title = "Write Metadata To Downloads"
) {
    override val icon: ImageVector
        @Composable
        get() = Design.icons.language.filled

    override val description: String = "Write relevant information (title, artist, year) to downloaded tracks."
    override val helpLink: String? = null
    override val warning: String? = null
    override val isVisible: Boolean = true
}
