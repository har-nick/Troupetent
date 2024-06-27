package uk.co.harnick.troupetent.core.account.bandcamp.domain.model

import uk.co.harnick.bandkit.data.remote.api.BandKit.Common.FAN_LOGIN
import uk.co.harnick.bandkit.data.remote.api.BandKit.Common.FAN_SIGNUP

enum class AccountAccessMethod(val initialUrl: String, val payload: String) {
    Login(initialUrl = FAN_LOGIN, payload = "LoginPayload.js"),
    Register(initialUrl = FAN_SIGNUP, payload = "RegisterPayload.js")
}
