package uk.co.harnick.troupetent.common.servicelocator

import uk.co.harnick.troupetent.common.servicelocator.modules.CoroutineModule
import uk.co.harnick.troupetent.common.servicelocator.modules.CoroutineModuleImpl
import uk.co.harnick.troupetent.common.servicelocator.modules.DatabaseModule
import uk.co.harnick.troupetent.common.servicelocator.modules.RepoBindings
import uk.co.harnick.troupetent.common.servicelocator.modules.RepoBindingsImpl
import uk.co.harnick.troupetent.common.servicelocator.modules.UseCaseModule
import uk.co.harnick.troupetent.common.servicelocator.modules.UseCaseModuleImpl
import uk.co.harnick.troupetent.common.servicelocator.modules.ViewModelModule
import uk.co.harnick.troupetent.common.servicelocator.modules.ViewModelModuleImpl

actual object ServiceLocator {
    actual val coroutineModule: CoroutineModule = CoroutineModuleImpl
    actual val databaseModule: DatabaseModule =
        uk.co.harnick.troupetent.common.servicelocator.modules.DatabaseModuleImpl()
    actual val repoBindings: RepoBindings = RepoBindingsImpl(databaseModule.localStorage)
    actual val useCaseModule: UseCaseModule = UseCaseModuleImpl(repoBindings)
    actual val viewModelModule: ViewModelModule =
        ViewModelModuleImpl(coroutineModule, useCaseModule)
}
