package uk.co.harnick.troupetent.core.settings.domain.model.display

import uk.co.harnick.troupetent.core.settings.domain.model.Setting

expect class MaterialYouIshSetting(value: Boolean = false) : Setting<Boolean> {
    override val description: String
    override val helpLink: String
}
