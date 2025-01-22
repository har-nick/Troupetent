package uk.co.harnick.troupetent.core.design.icons.material.outlined

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import uk.co.harnick.troupetent.core.design.icons.material.MaterialIcons

val MaterialIcons.Outlined.MenuOpen: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Filled.MenuOpen",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 960f,
        viewportHeight = 960f
    ).apply {
        path(fill = SolidColor(Color(0xFFE8EAED))) {
            moveTo(160f, 720f)
            quadToRelative(-17f, 0f, -28.5f, -11.5f)
            reflectiveQuadTo(120f, 680f)
            quadToRelative(0f, -17f, 11.5f, -28.5f)
            reflectiveQuadTo(160f, 640f)
            horizontalLineToRelative(440f)
            quadToRelative(17f, 0f, 28.5f, 11.5f)
            reflectiveQuadTo(640f, 680f)
            quadToRelative(0f, 17f, -11.5f, 28.5f)
            reflectiveQuadTo(600f, 720f)
            lineTo(160f, 720f)
            close()
            moveTo(756f, 652f)
            lineTo(612f, 508f)
            quadToRelative(-12f, -12f, -12f, -28f)
            reflectiveQuadToRelative(12f, -28f)
            lineToRelative(144f, -144f)
            quadToRelative(11f, -11f, 28f, -11f)
            reflectiveQuadToRelative(28f, 11f)
            quadToRelative(11f, 11f, 11f, 28f)
            reflectiveQuadToRelative(-11f, 28f)
            lineTo(696f, 480f)
            lineToRelative(116f, 116f)
            quadToRelative(11f, 11f, 11f, 28f)
            reflectiveQuadToRelative(-11f, 28f)
            quadToRelative(-11f, 11f, -28f, 11f)
            reflectiveQuadToRelative(-28f, -11f)
            close()
            moveTo(160f, 520f)
            quadToRelative(-17f, 0f, -28.5f, -11.5f)
            reflectiveQuadTo(120f, 480f)
            quadToRelative(0f, -17f, 11.5f, -28.5f)
            reflectiveQuadTo(160f, 440f)
            horizontalLineToRelative(320f)
            quadToRelative(17f, 0f, 28.5f, 11.5f)
            reflectiveQuadTo(520f, 480f)
            quadToRelative(0f, 17f, -11.5f, 28.5f)
            reflectiveQuadTo(480f, 520f)
            lineTo(160f, 520f)
            close()
            moveTo(160f, 320f)
            quadToRelative(-17f, 0f, -28.5f, -11.5f)
            reflectiveQuadTo(120f, 280f)
            quadToRelative(0f, -17f, 11.5f, -28.5f)
            reflectiveQuadTo(160f, 240f)
            horizontalLineToRelative(440f)
            quadToRelative(17f, 0f, 28.5f, 11.5f)
            reflectiveQuadTo(640f, 280f)
            quadToRelative(0f, 17f, -11.5f, 28.5f)
            reflectiveQuadTo(600f, 320f)
            lineTo(160f, 320f)
            close()
        }
    }.build()
}
