package uk.co.harnick.troupetent.core.account.bandcamp.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOneOrNull
import kotlinx.coroutines.flow.Flow
import uk.co.harnick.troupetent.LocalStorage
import uk.co.harnick.troupetent.bandcamp.BandcampAccountEntity
import uk.co.harnick.troupetent.core.account.bandcamp.domain.model.BandcampAccount
import uk.co.harnick.troupetent.core.account.bandcamp.domain.repository.AccountRepo
import kotlin.coroutines.CoroutineContext

class AccountRepoImpl(db: LocalStorage) : AccountRepo {
    private val accountQueries = db.bandcamp_accountQueries

    override fun deleteAccount(id: Long) = accountQueries.delete(id)

    override fun loadAccounts(callerContext: CoroutineContext): Flow<List<BandcampAccountEntity>> =
        accountQueries.load()
            .asFlow()
            .mapToList(callerContext)

    override fun loadCurrentAccount(callerContext: CoroutineContext): Flow<BandcampAccountEntity?> =
        accountQueries.load()
            .asFlow()
            .mapToOneOrNull(callerContext)

    override fun saveAccount(newAccount: BandcampAccount) = with(newAccount) {
        accountQueries.save(avatarId, bannerId, id, nickname, ownerId, token, username)
    }
}
