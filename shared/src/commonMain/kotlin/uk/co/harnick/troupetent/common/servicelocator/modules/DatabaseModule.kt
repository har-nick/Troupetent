package uk.co.harnick.troupetent.common.servicelocator.modules

import uk.co.harnick.troupetent.LocalStorage

interface DatabaseModule {
    val localStorage: LocalStorage
}

expect class DatabaseModuleImpl : DatabaseModule {
    override val localStorage: LocalStorage
}
