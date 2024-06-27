package uk.co.harnick.troupetent.core.player.data.repository

import uk.co.harnick.bandkit.data.model.Track
import uk.co.harnick.troupetent.ExoPlayerService
import uk.co.harnick.troupetent.core.player.domain.repository.PlayerRepo

actual class PlayerRepoImpl(private val service: ExoPlayerService? = null) : PlayerRepo {
    override fun addToQueue(track: Track) {

    }

    override fun removeFromQueue(index: Int) {
    }

    override fun shiftQueuePosition(currentIndex: Int, targetIndex: Int) {
    }

    override fun updateToken(newToken: String) {
    }
}
