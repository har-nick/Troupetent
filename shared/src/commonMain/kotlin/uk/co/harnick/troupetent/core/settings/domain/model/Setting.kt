package uk.co.harnick.troupetent.core.settings.domain.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

open class Setting<T>(
    open val value: T,
    open val title: String
) {
    open val icon: ImageVector?
        @Composable
        get() = null

    open val description: String? = null
    open val helpLink: String? = null
    open val warning: String? = null
    open val isVisible: Boolean = true
}
