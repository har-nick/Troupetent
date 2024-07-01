package uk.co.harnick.troupetent.core.design.color

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White

class MaterialColorDesign(
    override val isDark: Boolean,
    override val accent: Color = Color(58, 23, 114),
    override val backgroundLight: Color = Color(216, 210, 225),
    override val backgroundDark: Color = Color(44, 44, 52),
    override val error: Color = Color(171, 73, 103),
    override val success: Color = Color(130, 209, 115),
    override val warning: Color = Color(243, 146, 55),
    override val onAccent: Color = White,
    override val onBackground: Color = if (isDark) White else Black,
    override val onError: Color = Color(44, 44, 44),
    override val onWarning: Color = White,
    override val onSuccess: Color = Black
) : ColorTokens
