package uk.co.harnick.troupetent.core.util.compose

import android.graphics.Bitmap
import android.graphics.Bitmap.Config
import android.graphics.Picture

fun Picture.toBitmap(config: Config = Config.ARGB_8888): Bitmap {
    val bitmap = Bitmap.createBitmap(width, height, config)

    val canvas = android.graphics.Canvas(bitmap)
    canvas.drawColor(android.graphics.Color.WHITE)
    canvas.drawPicture(this)
    return bitmap
}
