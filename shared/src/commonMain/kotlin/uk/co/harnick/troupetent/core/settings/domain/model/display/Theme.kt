package uk.co.harnick.troupetent.core.settings.domain.model.display

import uk.co.harnick.troupetent.core.settings.domain.model.EnumSettingValue

enum class Theme(override val label: String) : EnumSettingValue {
    Amoled(label = "Amoled"),
    Auto(label = "Follow system theme"),
    Dark(label = "Dark"),
    Light(label = "Light")
}
