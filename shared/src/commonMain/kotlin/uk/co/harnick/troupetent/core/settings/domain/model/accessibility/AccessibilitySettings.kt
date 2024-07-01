package uk.co.harnick.troupetent.core.settings.domain.model.accessibility

import uk.co.harnick.troupetent.local.settings.AccessibilitySettingsEntity

data class AccessibilitySettings(
    val leftHandedMode: LeftHandedModeSetting = LeftHandedModeSetting()
)

fun AccessibilitySettingsEntity.toAccessibilitySettings() =
    AccessibilitySettings(
        leftHandedMode = leftHandedMode ?: LeftHandedModeSetting()
    )
