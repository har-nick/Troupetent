package uk.co.harnick.troupetent.core.design.typography

import uk.co.harnick.troupetent.core.design.typography.ios.SanFranciscoTypography
import uk.co.harnick.troupetent.core.design.typography.material.MaterialTypography
import uk.co.harnick.troupetent.core.util.DeviceInfo
import uk.co.harnick.troupetent.core.util.Platform

val DefaultTypography = when (DeviceInfo.platform) {
    Platform.iOS -> SanFranciscoTypography
    else -> MaterialTypography
}
