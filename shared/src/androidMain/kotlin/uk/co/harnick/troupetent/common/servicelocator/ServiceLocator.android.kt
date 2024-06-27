package uk.co.harnick.troupetent.common.servicelocator

import android.app.Application
import android.content.Context
import uk.co.harnick.troupetent.common.servicelocator.modules.CoroutineModule
import uk.co.harnick.troupetent.common.servicelocator.modules.CoroutineModuleImpl
import uk.co.harnick.troupetent.common.servicelocator.modules.DatabaseModule
import uk.co.harnick.troupetent.common.servicelocator.modules.DatabaseModuleImpl
import uk.co.harnick.troupetent.common.servicelocator.modules.PlayerModule
import uk.co.harnick.troupetent.common.servicelocator.modules.PlayerModuleImpl
import uk.co.harnick.troupetent.common.servicelocator.modules.RepoBindings
import uk.co.harnick.troupetent.common.servicelocator.modules.RepoBindingsImpl
import uk.co.harnick.troupetent.common.servicelocator.modules.UseCaseModule
import uk.co.harnick.troupetent.common.servicelocator.modules.UseCaseModuleImpl
import uk.co.harnick.troupetent.common.servicelocator.modules.ViewModelModule
import uk.co.harnick.troupetent.common.servicelocator.modules.ViewModelModuleImpl
import uk.co.harnick.troupetent.core.util.LateInitOnce

actual object ServiceLocator {
    private var appContext: Context by LateInitOnce()

    fun initialize(instance: Application) {
        appContext = instance.applicationContext
    }

    actual val coroutineModule: CoroutineModule = CoroutineModuleImpl
    actual val databaseModule: DatabaseModule by lazy { DatabaseModuleImpl(appContext) }
    actual val playerModule: PlayerModule by lazy { PlayerModuleImpl(appContext) }
    actual val repoBindings: RepoBindings by lazy { RepoBindingsImpl(databaseModule, playerModule) }
    actual val useCaseModule: UseCaseModule by lazy { UseCaseModuleImpl(repoBindings) }
    actual val viewModelModule: ViewModelModule by lazy {
        ViewModelModuleImpl(coroutineModule, repoBindings, useCaseModule)
    }
}
