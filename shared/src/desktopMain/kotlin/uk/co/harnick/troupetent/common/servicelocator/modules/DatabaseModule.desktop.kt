package uk.co.harnick.troupetent.common.servicelocator.modules

import uk.co.harnick.troupetent.LocalStorage
import uk.co.harnick.troupetent.core.db.data.local.DriverFactory
import uk.co.harnick.troupetent.core.db.data.local.createLocalStorage

actual class DatabaseModuleImpl : DatabaseModule {
    actual override val localStorage: LocalStorage = createLocalStorage(DriverFactory())
}
