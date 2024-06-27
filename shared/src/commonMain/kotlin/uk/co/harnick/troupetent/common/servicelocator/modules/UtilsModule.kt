package uk.co.harnick.troupetent.common.servicelocator.modules

import uk.co.harnick.troupetent.core.util.NetworkUtils

interface UtilsModule {
    val networkUtils: NetworkUtils
}

expect class UtilsModuleImpl : UtilsModule
