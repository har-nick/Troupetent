package uk.co.harnick.troupetent.core.settings.domain.model.display

import uk.co.harnick.bandkit.data.model.ImageSize
import uk.co.harnick.bandkit.data.model.ImageSize.Large
import uk.co.harnick.bandkit.data.model.ImageSize.Small
import uk.co.harnick.bandkit.data.model.ImageSize.XL
import uk.co.harnick.troupetent.core.settings.domain.model.EnumSettingValue

enum class ImageQuality(override val label: String, val apiRef: ImageSize) : EnumSettingValue {
    Low("Low", Small),
    Medium("Medium", ImageSize.Medium),
    High("High", Large),
    Ultra("Ultra", XL)
}
