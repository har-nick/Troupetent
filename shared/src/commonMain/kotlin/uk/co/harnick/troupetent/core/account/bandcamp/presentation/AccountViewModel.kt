package uk.co.harnick.troupetent.core.account.bandcamp.presentation

import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import uk.co.harnick.bandkit.data.model.BandcampToken
import uk.co.harnick.troupetent.common.servicelocator.modules.IODispatcher
import uk.co.harnick.troupetent.core.account.bandcamp.domain.repository.AccountRepo
import uk.co.harnick.troupetent.core.account.bandcamp.domain.usecase.AccountUseCases
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountEvent.AccessMethodInteraction
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountEvent.Login
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountEvent.LoginError
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountEvent.ShowWebView
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountEvent.ToggleTokenDialog
import uk.co.harnick.troupetent.core.ui.presentation.StatefulViewModel
import uk.co.harnick.troupetent.core.util.Return.Error
import uk.co.harnick.troupetent.core.util.Return.InProgress

class AccountViewModel(
    private val accountUseCases: AccountUseCases,
    private val accountRepo: AccountRepo,
    private val ioDispatcher: IODispatcher
) : StatefulViewModel<AccountState, AccountEvent>(AccountState()) {
    override fun onEvent(event: AccountEvent) {
        when (event) {
            is Login -> checkToken(event.token)
            is LoginError -> sendEvent(event)
            is AccessMethodInteraction -> mutableState.update { it.copy(accessIntent = event.method) }
            is ShowWebView -> mutableState.update { it.copy(accessWebViewVisible = true) }
            is ToggleTokenDialog -> mutableState.update { it.copy(tokenDialogVisible = !it.tokenDialogVisible) }
        }
    }

    init {
        monitorAccounts()
    }

    private fun checkToken(token: String) = try {
        val token = BandcampToken(token)
        login(token)
    } catch (e: Exception) {
        mutableState.update { it.copy() }
    }

    private fun monitorAccounts() {
        accountRepo.loadAccounts(vmContext)
            .flowOn(ioDispatcher)
            .map { accounts -> accounts.sortedBy { it.dateTimeLastUsed } }
            .onEach { accountList ->
                mutableState.update {
                    it.copy(accountList = accountList, isLoadingAccounts = false)
                }
            }
            .launchIn(vmScope)
    }

    private fun login(token: BandcampToken) {
        accountUseCases.getAccountDetails(token)
            .flowOn(ioDispatcher)
            .onEach { emission ->
                mutableState.update { it.copy(isLoggingIn = (emission is InProgress)) }
                if (emission is Error) sendEvent(LoginError(emission.reason))
            }
            .launchIn(vmScope)
    }
}
