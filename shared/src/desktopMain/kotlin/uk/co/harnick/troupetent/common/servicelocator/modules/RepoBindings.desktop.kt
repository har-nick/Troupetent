package uk.co.harnick.troupetent.common.servicelocator.modules

import uk.co.harnick.troupetent.core.account.bandcamp.data.repository.AccountRepoImpl
import uk.co.harnick.troupetent.core.account.bandcamp.domain.repository.AccountRepo
import uk.co.harnick.troupetent.core.settings.data.repository.SettingsRepoImpl
import uk.co.harnick.troupetent.core.settings.domain.SettingsRepo

actual class RepoBindingsImpl actual constructor(databaseModule: DatabaseModule) : RepoBindings {
    override val accountRepo: AccountRepo = AccountRepoImpl(databaseModule.localStorage)
    override val settingsRepo: SettingsRepo = SettingsRepoImpl(databaseModule.localStorage)
}
