package uk.co.harnick.troupetent.common.servicelocator.modules

import uk.co.harnick.troupetent.core.settings.presentation.SettingsVM

interface ViewModelModule {
    val settingsVM: SettingsVM
}

class ViewModelModuleImpl(
    coroutineModule: CoroutineModule,
    repoBindings: RepoBindings,
    useCaseModule: UseCaseModule
) : ViewModelModule {
    override val settingsVM: SettingsVM =
        SettingsVM(coroutineModule.ioDispatcher, repoBindings.settingsRepo)
}
