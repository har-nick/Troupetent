package uk.co.harnick.troupetent.core.settings.domain.model.display

import uk.co.harnick.troupetent.core.design.typography.DefaultTypography
import uk.co.harnick.troupetent.core.settings.domain.model.Setting

class FontSetting(
    override val value: Typography = DefaultTypography
) : Setting<Typography>(
    value = value,
    title = "Font"
) {

}
