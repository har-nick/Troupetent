package uk.co.harnick.troupetent.core.ui.presentation

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class Elevation(val dp: Dp) {
    Level0(0.dp),
    Level1(1.dp),
    Level2(3.dp),
    Level3(6.dp),
    Level4(8.dp),
    Level5(12.dp);

    companion object {
        val LOWEST = Level0
        val HIGHEST = Level5
    }
}
