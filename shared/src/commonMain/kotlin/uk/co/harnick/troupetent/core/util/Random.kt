package uk.co.harnick.troupetent.core.util

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Random {
    fun string(length: Int = 32): String = (1..length)
        .map { Random.nextInt(from = 0, until = 9) }
        .joinToString("")

    fun int(length: Int = 32): Int = string(length).toInt()

    fun color(): Color = Color(
        red = Random.nextInt(256),
        green = Random.nextInt(256),
        blue = Random.nextInt(256)
    )
}
