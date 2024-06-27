package uk.co.harnick.troupetent.core.util

import kotlinx.coroutines.flow.Flow

interface NetworkUtils {
    val networkIsAvailable: Flow<Boolean>
}
