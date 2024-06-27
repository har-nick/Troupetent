package uk.co.harnick.troupetent.common.servicelocator.modules

import uk.co.harnick.troupetent.core.account.bandcamp.data.repository.AccountRepoImpl
import uk.co.harnick.troupetent.core.account.bandcamp.domain.repository.AccountRepo
import uk.co.harnick.troupetent.core.player.data.repository.PlayerRepoImpl
import uk.co.harnick.troupetent.core.player.domain.repository.PlayerRepo
import uk.co.harnick.troupetent.core.settings.data.repository.SettingsRepoImpl
import uk.co.harnick.troupetent.core.settings.domain.repository.SettingsRepo
import uk.co.harnick.troupetent.feature.library.data.repository.LibraryRepoImpl
import uk.co.harnick.troupetent.feature.library.domain.repository.LibraryRepo

actual class RepoBindingsImpl(databaseModule: DatabaseModule, playerModule: PlayerModule) : RepoBindings {
    override val accountRepo: AccountRepo = AccountRepoImpl(databaseModule.localStorage)
    override val libraryRepo: LibraryRepo = LibraryRepoImpl(databaseModule.localStorage)
    override val playerRepo: PlayerRepo = PlayerRepoImpl()
    override val settingsRepo: SettingsRepo = SettingsRepoImpl(databaseModule.localStorage)
}
