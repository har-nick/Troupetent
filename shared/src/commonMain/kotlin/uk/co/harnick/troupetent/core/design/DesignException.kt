package uk.co.harnick.troupetent.core.design

import androidx.compose.ui.graphics.Color

sealed class DesignException(message: String) : Error(message) {
    class MissingComponentImplementation(
        component: String,
        design: ComponentDesign
    ) : DesignException("Missing implementation for $component in style '${design.label}'")

    class MissingContentColorImplementation(
        color: Color
    ) : DesignException("Missing appropriate content color for ${color.value}.")
}
