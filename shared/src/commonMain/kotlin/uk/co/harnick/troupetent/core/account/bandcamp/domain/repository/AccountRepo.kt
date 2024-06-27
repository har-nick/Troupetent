package uk.co.harnick.troupetent.core.account.bandcamp.domain.repository

import kotlinx.coroutines.flow.Flow
import uk.co.harnick.troupetent.Account
import kotlin.coroutines.CoroutineContext

interface AccountRepo {
    fun deleteAccount(id: Long)
    fun loadAccounts(callerContext: CoroutineContext): Flow<List<Account>>
    fun loadCurrentAccount(callerContext: CoroutineContext): Flow<Account?>
    fun saveAccount(newAccount: Account)
}
