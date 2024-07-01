package uk.co.harnick.troupetent.core.account.bandcamp.domain.model

data class BandcampAccount(
    val avatarId: Long?,
    val bannerId: Long?,
    val id: Long,
    val nickname: String?,
    val ownerId: Long,
    val token: String,
    val username: String
)
