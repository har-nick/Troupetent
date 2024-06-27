package uk.co.harnick.troupetent.core.account.bandcamp.data.local.adapters

import app.cash.sqldelight.ColumnAdapter
import uk.co.harnick.bandkit.data.model.BandcampToken

object BandcampTokenAdapter : ColumnAdapter<BandcampToken, String> {
    override fun decode(databaseValue: String): BandcampToken = BandcampToken(databaseValue)
    override fun encode(value: BandcampToken): String = value.token
}
