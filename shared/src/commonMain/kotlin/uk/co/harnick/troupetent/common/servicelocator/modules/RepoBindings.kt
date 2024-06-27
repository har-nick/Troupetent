package uk.co.harnick.troupetent.common.servicelocator.modules

import uk.co.harnick.troupetent.core.account.bandcamp.domain.repository.AccountRepo
import uk.co.harnick.troupetent.core.player.domain.repository.PlayerRepo
import uk.co.harnick.troupetent.core.settings.domain.repository.SettingsRepo
import uk.co.harnick.troupetent.feature.library.domain.repository.LibraryRepo

interface RepoBindings {
    val accountRepo: AccountRepo
    val libraryRepo: LibraryRepo
    val playerRepo: PlayerRepo
    val settingsRepo: SettingsRepo
}

expect class RepoBindingsImpl : RepoBindings
