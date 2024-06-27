package uk.co.harnick.troupetent.core.settings.data.local.adapters

import androidx.compose.ui.graphics.Color
import uk.co.harnick.troupetent.core.settings.domain.model.display.SeedColorSetting

object SeedColorSettingAdapter : ColorSettingAdapter<SeedColorSetting> {
    override fun decode(databaseValue: Long): SeedColorSetting =
        SeedColorSetting(Color(databaseValue))
}
