package uk.co.harnick.troupetent.common.servicelocator.modules

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

typealias MainDispatcher = CoroutineDispatcher
typealias DefaultDispatcher = CoroutineDispatcher
typealias IODispatcher = CoroutineDispatcher

interface CoroutineModule {
    val mainDispatcher: MainDispatcher
    val defaultDispatcher: DefaultDispatcher
    val ioDispatcher: IODispatcher
}

object CoroutineModuleImpl : CoroutineModule {
    override val mainDispatcher: MainDispatcher by Dispatchers::Main
    override val defaultDispatcher: DefaultDispatcher by Dispatchers::Default
    override val ioDispatcher: IODispatcher by Dispatchers::IO
}
