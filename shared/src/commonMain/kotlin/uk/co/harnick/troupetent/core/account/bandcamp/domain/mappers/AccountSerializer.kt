package uk.co.harnick.troupetent.core.account.bandcamp.domain.mappers

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializer
import uk.co.harnick.troupetent.Account

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = Account::class)
object AccountSerializer
