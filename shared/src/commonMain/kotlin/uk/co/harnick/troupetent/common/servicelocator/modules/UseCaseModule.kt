package uk.co.harnick.troupetent.common.servicelocator.modules

import uk.co.harnick.troupetent.core.account.bandcamp.domain.usecase.AccountUseCases
import uk.co.harnick.troupetent.feature.library.domain.usecase.LibraryUseCases

interface UseCaseModule {
    val accountUseCases: AccountUseCases
    val libraryUseCases: LibraryUseCases
}

class UseCaseModuleImpl(repoBindings: RepoBindings) : UseCaseModule {
    override val accountUseCases: AccountUseCases = AccountUseCases(repoBindings.accountRepo)
    override val libraryUseCases: LibraryUseCases = LibraryUseCases(repoBindings.libraryRepo)
}
