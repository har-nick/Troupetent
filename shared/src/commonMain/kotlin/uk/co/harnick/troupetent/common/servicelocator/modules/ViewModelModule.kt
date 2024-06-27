package uk.co.harnick.troupetent.common.servicelocator.modules

import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountViewModel
import uk.co.harnick.troupetent.core.settings.presentation.SettingsViewModel

interface ViewModelModule {
    val accountViewModel: AccountViewModel
    val settingsViewModel: SettingsViewModel
}

class ViewModelModuleImpl(
    coroutineModule: CoroutineModule,
    repoBindings: RepoBindings,
    useCaseModule: UseCaseModule
) : ViewModelModule {
    override val accountViewModel: AccountViewModel =
        AccountViewModel(
            useCaseModule.accountUseCases,
            repoBindings.accountRepo,
            coroutineModule.ioDispatcher
        )
    override val settingsViewModel: SettingsViewModel =
        SettingsViewModel(coroutineModule.ioDispatcher, repoBindings.settingsRepo)
}
