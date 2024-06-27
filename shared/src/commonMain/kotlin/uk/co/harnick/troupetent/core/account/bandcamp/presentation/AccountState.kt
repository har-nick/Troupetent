package uk.co.harnick.troupetent.core.account.bandcamp.presentation

import uk.co.harnick.troupetent.Account
import uk.co.harnick.troupetent.core.account.bandcamp.domain.model.AccountAccessMethod

data class AccountState(
    val accessWebViewVisible: Boolean = false,
    val accessIntent: AccountAccessMethod? = null,
    val accountList: List<Account> = listOf(),
    val error: String? = null,
    val isLoadingAccounts: Boolean = true,
    val isLoggingIn: Boolean = false,
    val tokenDialogVisible: Boolean = false
) {
    val currentAccount: Account? = accountList.firstOrNull()
}
