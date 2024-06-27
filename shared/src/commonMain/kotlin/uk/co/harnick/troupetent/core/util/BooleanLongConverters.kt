package uk.co.harnick.troupetent.core.util

fun Boolean.toLong(): Long = if (this) 1L else 0L

fun Long.toBool(): Comparable<Boolean> = when (this) {
    1L -> true
    0L -> false
    else -> throw IllegalArgumentException("Long does not represent a Boolean value")
}
