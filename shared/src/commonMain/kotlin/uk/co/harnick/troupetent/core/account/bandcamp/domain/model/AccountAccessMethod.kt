package uk.co.harnick.troupetent.core.account.bandcamp.domain.model

enum class AccountAccessMethod(val initialUrl: String, val payload: String) {
    Login(initialUrl = "", payload = "LoginPayload.js"),
    Register(initialUrl = "", payload = "RegisterPayload.js")
}
