package uk.co.harnick.troupetent.core.util.compose

import android.graphics.Bitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.ColorUtils

val Bitmap.luminosity: Float
    get() {
        val androidBitmap = this.asImageBitmap().asAndroidBitmap()
        var luminanceSum = 0F
        var pixelCount = 0

        for (x in 0 until androidBitmap.width) {
            for (y in 0 until androidBitmap.height) {
                val color = androidBitmap.getPixel(x, y)
                val luminance = ColorUtils.calculateLuminance(color)
                luminanceSum += luminance.toFloat()
                pixelCount++
            }
        }

        return luminanceSum / pixelCount
    }
