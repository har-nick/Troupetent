package com.harnick.troupetent.core.api.data.remote.bandcamp.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponseEntity(
    @SerialName("error")
    val errorExists: Boolean,
    @SerialName("error_message")
    val errorMessage: String
)
