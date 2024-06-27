package uk.co.harnick.troupetent.core.player.domain.repository

import uk.co.harnick.bandkit.data.model.Track

interface PlayerRepo {
    fun addToQueue(track: Track)
    fun removeFromQueue(index: Int)
    fun shiftQueuePosition(currentIndex: Int, targetIndex: Int)
    fun updateToken(newToken: String)
}
