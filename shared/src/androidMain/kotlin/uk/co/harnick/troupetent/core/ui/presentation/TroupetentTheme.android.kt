package uk.co.harnick.troupetent.core.ui.presentation

import android.app.WallpaperManager
import android.app.WallpaperManager.FLAG_SYSTEM
import android.graphics.Bitmap
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.O_MR1
import android.os.Build.VERSION_CODES.S
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import com.kmpalette.rememberDominantColorState
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.rememberDynamicMaterialThemeState
import uk.co.harnick.troupetent.core.settings.domain.model.display.DisplaySettings
import uk.co.harnick.troupetent.core.settings.domain.model.display.Theme.Amoled
import uk.co.harnick.troupetent.core.settings.domain.model.display.Theme.Auto
import uk.co.harnick.troupetent.core.settings.domain.model.display.Theme.Dark
import uk.co.harnick.troupetent.core.settings.domain.model.display.Theme.Light
import java.security.InvalidParameterException

actual object TroupetentTheme {
    @RequiresApi(O_MR1)
    @Composable
    private fun seedByWallpaperColors(wallpaperManager: WallpaperManager): Color {
        val wallpaperColorArgb =
            wallpaperManager.getWallpaperColors(FLAG_SYSTEM)?.primaryColor?.toArgb()

        return wallpaperColorArgb
            ?.let { Color(it) }
            ?: throw InvalidParameterException("Wallpaper colors is null")
    }

    @Composable
    private fun seedByWallpaperBitmap(wallpaperManager: WallpaperManager): Color {
        val wallpaperImage = wallpaperManager.fastDrawable
        val dominantColorState = rememberDominantColorState()

        LaunchedEffect(wallpaperImage) {
            wallpaperImage
                ?.let {
                    val wallpaperBitmap = Bitmap.createBitmap(
                        it.intrinsicWidth,
                        it.intrinsicHeight,
                        Bitmap.Config.ARGB_8888
                    ).asImageBitmap()
                    dominantColorState.updateFrom(wallpaperBitmap)
                }
        }
        return dominantColorState.color
    }

    @RequiresApi(S)
    @Composable
    private fun MaterialYou(useDarkTheme: Boolean, content: @Composable () -> Unit) {
        val localContext = LocalContext.current
        val colorScheme = when (useDarkTheme) {
            true -> dynamicDarkColorScheme(localContext)
            false -> dynamicLightColorScheme(localContext)
        }

        MaterialTheme(colorScheme) { content() }
    }

    @Composable
    actual operator fun invoke(displaySettings: DisplaySettings, content: @Composable () -> Unit) {
        val localContext = LocalContext.current
        val view = LocalView.current
        val deviceIsInDarkMode = isSystemInDarkTheme()
        val theme = displaySettings.theme.value
        val wallpaperManager = WallpaperManager.getInstance(localContext)

        val materialYouEnabled =
            (displaySettings.materialYou.value || displaySettings.materialYouIsh.value)

        val useDarkTheme = when (theme) {
            Amoled, Dark -> true
            Light -> false
            Auto -> deviceIsInDarkMode
        }

        val seedColor = when {
            (SDK_INT in O_MR1 until S) -> seedByWallpaperColors(wallpaperManager)
            (SDK_INT < O_MR1) -> seedByWallpaperBitmap(wallpaperManager)
            else -> displaySettings.seedColor.value
        }

        val dynamicMaterialThemeState = rememberDynamicMaterialThemeState(
            seedColor = seedColor,
            isDark = useDarkTheme,
            isAmoled = (theme == Amoled),
            style = displaySettings.palette.value.style
        )

        if (!view.isInEditMode) {
            val statusBarStyle = SystemBarStyle.auto(
                darkScrim = Color.Transparent.toArgb(),
                lightScrim = Color.Transparent.toArgb(),
                detectDarkMode = { useDarkTheme }
            )
            SideEffect { (view.context as ComponentActivity).enableEdgeToEdge(statusBarStyle) }
        }

        when {
            (SDK_INT >= S && materialYouEnabled) -> MaterialYou(useDarkTheme, content)
            else -> DynamicMaterialTheme(dynamicMaterialThemeState) { content() }
        }
    }
}
