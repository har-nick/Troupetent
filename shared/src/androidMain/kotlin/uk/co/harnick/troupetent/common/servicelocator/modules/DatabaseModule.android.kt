package uk.co.harnick.troupetent.common.servicelocator.modules

import android.content.Context
import uk.co.harnick.troupetent.LocalStorage
import uk.co.harnick.troupetent.core.db.data.local.DriverFactory
import uk.co.harnick.troupetent.core.db.data.local.createLocalStorage

actual class DatabaseModuleImpl(appContext: Context) : DatabaseModule {
    actual override val localStorage: LocalStorage =
        createLocalStorage(DriverFactory(appContext))
}
