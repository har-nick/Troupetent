package uk.co.harnick.troupetent.core.account.bandcamp.domain.repository

import kotlinx.coroutines.flow.Flow
import uk.co.harnick.troupetent.bandcamp.BandcampAccountEntity
import uk.co.harnick.troupetent.core.account.bandcamp.domain.model.BandcampAccount
import kotlin.coroutines.CoroutineContext

interface AccountRepo {
    fun deleteAccount(id: Long)
    fun loadAccounts(callerContext: CoroutineContext): Flow<List<BandcampAccountEntity>>
    fun loadCurrentAccount(callerContext: CoroutineContext): Flow<BandcampAccountEntity?>
    fun saveAccount(newAccount: BandcampAccount)
}
