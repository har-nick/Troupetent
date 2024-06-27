package uk.co.harnick.troupetent.core.account.bandcamp.domain.usecase

import uk.co.harnick.troupetent.core.account.bandcamp.domain.repository.AccountRepo

class AccountUseCases(accountRepo: AccountRepo) {
    val getAccountDetails: GetBandcampAccountDetails = GetBandcampAccountDetails(accountRepo)
}
