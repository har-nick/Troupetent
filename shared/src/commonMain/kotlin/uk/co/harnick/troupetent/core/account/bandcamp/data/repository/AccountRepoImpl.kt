package uk.co.harnick.troupetent.core.account.bandcamp.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uk.co.harnick.troupetent.Account
import uk.co.harnick.troupetent.LocalStorage
import uk.co.harnick.troupetent.core.account.bandcamp.domain.repository.AccountRepo
import kotlin.coroutines.CoroutineContext

class AccountRepoImpl(db: LocalStorage) : AccountRepo {
    private val accountQueries = db.accountQueries

    override fun deleteAccount(id: Long) = accountQueries.delete(id)

    override fun loadAccounts(callerContext: CoroutineContext): Flow<List<Account>> =
        accountQueries.load()
            .asFlow()
            .mapToList(callerContext)

    override fun loadCurrentAccount(callerContext: CoroutineContext): Flow<Account?> =
        accountQueries.load()
            .asFlow()
            .mapToList(callerContext)
            .map { accounts -> accounts.minByOrNull { it.dateTimeLastUsed } }

    override fun saveAccount(newAccount: Account) = with(newAccount) {
        accountQueries.save(avatarId, bannerId, id, nickname, dateTimeLastUsed, token, username)
    }
}
