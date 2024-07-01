package uk.co.harnick.troupetent.core.design.icons

import uk.co.harnick.troupetent.core.design.icons.ios.SFIcons
import uk.co.harnick.troupetent.core.design.icons.material.MaterialIcons
import uk.co.harnick.troupetent.core.util.DeviceInfo
import uk.co.harnick.troupetent.core.util.Platform

val DefaultIconDesign = when (DeviceInfo.platform) {
    Platform.iOS -> SFIcons
    else -> MaterialIcons
}
