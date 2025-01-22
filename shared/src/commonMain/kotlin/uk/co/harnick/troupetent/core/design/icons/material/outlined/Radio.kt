package uk.co.harnick.troupetent.core.design.icons.material.outlined

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import uk.co.harnick.troupetent.core.design.icons.material.MaterialIcons

val MaterialIcons.Outlined.Radio: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Outlined.Radio",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 960f,
        viewportHeight = 960f
    ).apply {
        path(fill = SolidColor(Color(0xFFE8EAED))) {
            moveTo(160f, 880f)
            quadToRelative(-33f, 0f, -56.5f, -23.5f)
            reflectiveQuadTo(80f, 800f)
            verticalLineToRelative(-480f)
            quadToRelative(0f, -25f, 13.5f, -45f)
            reflectiveQuadToRelative(36.5f, -29f)
            lineToRelative(473f, -193f)
            quadToRelative(14f, -5f, 27.5f, 0.5f)
            reflectiveQuadTo(649f, 73f)
            quadToRelative(5f, 14f, -0.5f, 27.5f)
            reflectiveQuadTo(629f, 119f)
            lineTo(332f, 240f)
            horizontalLineToRelative(468f)
            quadToRelative(33f, 0f, 56.5f, 23.5f)
            reflectiveQuadTo(880f, 320f)
            verticalLineToRelative(480f)
            quadToRelative(0f, 33f, -23.5f, 56.5f)
            reflectiveQuadTo(800f, 880f)
            lineTo(160f, 880f)
            close()
            moveTo(160f, 800f)
            horizontalLineToRelative(640f)
            verticalLineToRelative(-280f)
            lineTo(160f, 520f)
            verticalLineToRelative(280f)
            close()
            moveTo(320f, 760f)
            quadToRelative(42f, 0f, 71f, -29f)
            reflectiveQuadToRelative(29f, -71f)
            quadToRelative(0f, -42f, -29f, -71f)
            reflectiveQuadToRelative(-71f, -29f)
            quadToRelative(-42f, 0f, -71f, 29f)
            reflectiveQuadToRelative(-29f, 71f)
            quadToRelative(0f, 42f, 29f, 71f)
            reflectiveQuadToRelative(71f, 29f)
            close()
            moveTo(160f, 440f)
            horizontalLineToRelative(480f)
            verticalLineToRelative(-40f)
            quadToRelative(0f, -17f, 11.5f, -28.5f)
            reflectiveQuadTo(680f, 360f)
            quadToRelative(17f, 0f, 28.5f, 11.5f)
            reflectiveQuadTo(720f, 400f)
            verticalLineToRelative(40f)
            horizontalLineToRelative(80f)
            verticalLineToRelative(-120f)
            lineTo(160f, 320f)
            verticalLineToRelative(120f)
            close()
            moveTo(160f, 800f)
            verticalLineToRelative(-280f)
            verticalLineToRelative(280f)
            close()
        }
    }.build()
}
