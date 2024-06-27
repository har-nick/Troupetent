package uk.co.harnick.troupetent.core.account.bandcamp.domain.usecase

import com.github.michaelbull.result.getOrThrow
import kotlinx.coroutines.flow.flow
import uk.co.harnick.bandkit.data.model.BandcampToken
import uk.co.harnick.bandkit.data.remote.api.BandKit
import uk.co.harnick.troupetent.Account
import uk.co.harnick.troupetent.core.account.bandcamp.domain.repository.AccountRepo
import uk.co.harnick.troupetent.core.util.Return
import uk.co.harnick.troupetent.core.util.Return.InProgress.Fetching

class GetBandcampAccountDetails(private val accountRepo: AccountRepo) {
    operator fun invoke(token: BandcampToken) = flow<Return<Account>> {
        emit(Fetching(status = "Fetching user data..."))

        val summary = BandKit
            .fetchLibrarySummary(token)
            .getOrThrow()

        val account = BandKit
            .fetchUser(summary.ownerId, summary.ownerUsername)
            .getOrThrow()
            .run {
                Account(
                    avatarId = avatarId,
                    bannerId = bannerId,
                    dateTimeLastUsed = System.currentTimeMillis(),
                    id = summary.ownerId,
                    nickname = displayName,
                    token = token,
                    username = username
                )
            }

        accountRepo.saveAccount(account)

        emit(Return.Success())
    }
}
