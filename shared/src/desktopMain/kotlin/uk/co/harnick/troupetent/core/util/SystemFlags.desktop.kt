package uk.co.harnick.troupetent.core.util

import uk.co.harnick.troupetent.core.util.Platform.Desktop

actual object DeviceInfo {
    actual val materialYouSupported: Boolean = false
    actual val platform: Platform = Desktop
}
