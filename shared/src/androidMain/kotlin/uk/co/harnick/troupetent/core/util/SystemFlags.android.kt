package uk.co.harnick.troupetent.core.util

import android.os.Build.VERSION.SDK_INT
import uk.co.harnick.troupetent.core.util.Platform.Android

actual object DeviceInfo {
    actual val materialYouSupported: Boolean = (SDK_INT > 30)
    actual val platform: Platform = Android
}
