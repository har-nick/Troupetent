package uk.co.harnick.troupetent.core.settings.domain.model.display

import uk.co.harnick.troupetent.core.settings.domain.model.EnumSettingValue

enum class ImageQuality(override val label: String, val apiRef: String) : EnumSettingValue {
    Low("Low", "9"),
    Medium("Medium", "16"),
    High("High", "10"),
}
