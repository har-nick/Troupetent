package uk.co.harnick.troupetent.core.design

import uk.co.harnick.troupetent.core.util.DeviceInfo

sealed class ComponentDesign(val label: String) {
    sealed class Material(label: String) : ComponentDesign(label) {
        data object M2 : ComponentDesign("Material 2")
        data class M3(
            val materialYouEnabled: Boolean = DeviceInfo.materialYouSupported
        ) : Material("Material 3")
    }

    data object Glassmorphism : ComponentDesign("Glassmorphism")
    data object Homage : ComponentDesign("Homage")
    data object iOS : ComponentDesign("iOS")
    data object NeoBrutalism : ComponentDesign("Neo-Brutalism")
    data object Skeuomorphism : ComponentDesign("Skeuomorphism")
}
