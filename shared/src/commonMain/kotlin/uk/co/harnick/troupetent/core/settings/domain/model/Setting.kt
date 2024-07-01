package uk.co.harnick.troupetent.core.settings.domain.model

import org.jetbrains.compose.resources.DrawableResource

interface Setting<T> {
    val description: String?
    val helpLink: String?
    val icon: DrawableResource
    val isVisible: Boolean
    val title: String
    val value: T
    val warning: String?
}
