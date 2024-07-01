package uk.co.harnick.troupetent.common.servicelocator.modules

import uk.co.harnick.troupetent.core.account.bandcamp.domain.repository.AccountRepo
import uk.co.harnick.troupetent.core.settings.domain.SettingsRepo

interface RepoBindings {
    val accountRepo: AccountRepo
    val settingsRepo: SettingsRepo
}

expect class RepoBindingsImpl(databaseModule: DatabaseModule) : RepoBindings
