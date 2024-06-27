package uk.co.harnick.troupetent.core.account.bandcamp.presentation

import uk.co.harnick.troupetent.core.account.bandcamp.domain.model.AccountAccessMethod

sealed interface AccountEvent {
    data class Login(val token: String) : AccountEvent
    sealed class AccessMethodInteraction(val method: AccountAccessMethod? = null) : AccountEvent {
        data class SetAccessMethod(
            val newMethod: AccountAccessMethod
        ) : AccessMethodInteraction(newMethod)

        data object ClearMethod : AccessMethodInteraction()
    }

    data object ShowWebView : AccountEvent
    data object ToggleTokenDialog : AccountEvent

    data class LoginError(val cause: String?) : AccountEvent
}
