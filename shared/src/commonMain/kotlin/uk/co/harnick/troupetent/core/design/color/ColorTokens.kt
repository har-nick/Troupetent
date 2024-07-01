package uk.co.harnick.troupetent.core.design.color

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import uk.co.harnick.troupetent.core.design.DesignException.MissingContentColorImplementation

interface ColorTokens {
    val isDark: Boolean
    val accent: Color
    val backgroundDark: Color
    val backgroundLight: Color
    val error: Color
    val warning: Color
    val success: Color
    val onAccent: Color
    val onBackground: Color
    val onError: Color
    val onWarning: Color
    val onSuccess: Color
    val background: Color
        get() = if (isDark) backgroundDark else backgroundLight

    // TODO: Provide mappings
    @Composable
    fun toMaterialTheme(
        content: @Composable () -> Unit
    ) = MaterialTheme(
        colorScheme = ColorScheme(
            primary = accent,
            onPrimary = onAccent,
            primaryContainer = accent.copy(alpha = 0.8F),
            onPrimaryContainer = onAccent,
            inversePrimary = onAccent,
            secondary = accent,
            onSecondary = onAccent,
            secondaryContainer = accent.copy(alpha = 0.6F),
            onSecondaryContainer = onAccent,
            tertiary = accent,
            onTertiary = onAccent,
            tertiaryContainer = accent,
            onTertiaryContainer = onAccent,
            background = background,
            onBackground = onBackground,
            surface = background,
            onSurface = onBackground,
            surfaceVariant = accent.copy(alpha = 0.9F),
            onSurfaceVariant = onBackground,
            surfaceTint = background,
            inverseSurface = if (isDark) backgroundLight else backgroundDark,
            inverseOnSurface = if (!isDark) backgroundDark else backgroundLight,
            error = error,
            onError = onError,
            errorContainer = error,
            onErrorContainer = onError,
            outline = onBackground.copy(alpha = 0.3F),
            outlineVariant = accent.copy(alpha = 0.5F),
            scrim = Black,
            surfaceBright = background,
            surfaceDim = background,
            surfaceContainer = background,
            surfaceContainerHigh = backgroundDark.copy(alpha = 0.1F),
            surfaceContainerHighest = backgroundDark.copy(alpha = 0.15F),
            surfaceContainerLow = backgroundDark.copy(alpha = 0.05F),
            surfaceContainerLowest = backgroundDark
        ),
        typography = MaterialTheme.typography,
        content = content
    )

    @Composable
    fun contentColorFor(backgroundColor: Color) =
        when (backgroundColor) {
            accent -> onAccent
            background -> onBackground
            error -> onError
            warning -> onWarning
            onAccent, onBackground, onError, onWarning -> Color.Unspecified
            else -> throw MissingContentColorImplementation(backgroundColor)
        }
}
