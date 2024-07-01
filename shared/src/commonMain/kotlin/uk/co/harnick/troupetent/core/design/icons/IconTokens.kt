package uk.co.harnick.troupetent.core.design.icons

import androidx.compose.ui.graphics.vector.ImageVector

class IconTokens(
    val actionMenu: IconSet,
    val close: IconSet,
    val formatPaint: IconSet,
    val fullscreen: IconSet,
    val fullscreenExit: IconSet,
    val language: IconSet,
    val menuOpen: IconSet,
    val minimize: IconSet,
    val musicLibrary: IconSet,
    val musicQueue: IconSet,
    val musicRadio: IconSet,
    val photoSizeSelect: IconSet,
    val settings: IconSet,
) {
    class IconSet(
        val filled: ImageVector,
        val outlined: ImageVector
    )
}
