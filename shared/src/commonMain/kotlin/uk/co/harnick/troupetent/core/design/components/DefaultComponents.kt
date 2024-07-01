package uk.co.harnick.troupetent.core.design.components

import uk.co.harnick.troupetent.core.design.ComponentDesign
import uk.co.harnick.troupetent.core.design.ComponentDesign.Material.M3
import uk.co.harnick.troupetent.core.util.DeviceInfo
import uk.co.harnick.troupetent.core.util.Platform
import uk.co.harnick.troupetent.core.util.Platform.Android
import uk.co.harnick.troupetent.core.util.Platform.Desktop

val DefaultComponents = when (DeviceInfo.platform) {
    Android, Desktop -> M3()
    Platform.iOS -> ComponentDesign.iOS
}
