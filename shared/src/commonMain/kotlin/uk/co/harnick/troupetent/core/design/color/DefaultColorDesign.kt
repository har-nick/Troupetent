package uk.co.harnick.troupetent.core.design.color

import uk.co.harnick.troupetent.core.util.DeviceInfo
import uk.co.harnick.troupetent.core.util.Platform

val DefaultColorDesign = when (DeviceInfo.platform) {
    Platform.iOS -> iOSColorDesign(isDark = false)
    else -> MaterialColorDesign(isDark = false)
}
