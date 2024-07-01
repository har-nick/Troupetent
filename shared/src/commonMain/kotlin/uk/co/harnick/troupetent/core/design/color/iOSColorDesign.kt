package uk.co.harnick.troupetent.core.design.color

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White

class iOSColorDesign(
    override val isDark: Boolean,
    override val accent: Color = Color(0, 122, 255),
    override val backgroundLight: Color = Color(216, 210, 225),
    override val backgroundDark: Color = Color(31, 31, 33),
    override val error: Color = Color(255, 19, 0),
    override val success: Color = Color(76, 217, 100),
    override val warning: Color = Color(255, 149, 0),
    override val onAccent: Color = White,
    override val onBackground: Color = if (isDark) White else Black,
    override val onError: Color = Color(44, 44, 44),
    override val onWarning: Color = White,
    override val onSuccess: Color = Black
) : ColorTokens
