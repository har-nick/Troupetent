package uk.co.harnick.troupetent.common.servicelocator

import uk.co.harnick.troupetent.common.servicelocator.modules.CoroutineModule
import uk.co.harnick.troupetent.common.servicelocator.modules.DatabaseModule
import uk.co.harnick.troupetent.common.servicelocator.modules.PlayerModule
import uk.co.harnick.troupetent.common.servicelocator.modules.RepoBindings
import uk.co.harnick.troupetent.common.servicelocator.modules.UseCaseModule
import uk.co.harnick.troupetent.common.servicelocator.modules.ViewModelModule

expect object ServiceLocator {
    val coroutineModule: CoroutineModule
    val databaseModule: DatabaseModule
    val playerModule: PlayerModule
    val repoBindings: RepoBindings
    val useCaseModule: UseCaseModule
    val viewModelModule: ViewModelModule
}
