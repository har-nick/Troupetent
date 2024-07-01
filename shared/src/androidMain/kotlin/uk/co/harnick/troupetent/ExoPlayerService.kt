package uk.co.harnick.troupetent

import android.content.Intent
import androidx.annotation.OptIn
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService

class ExoPlayerService : MediaSessionService() {
    override fun onDestroy() {
        mediaSession?.run {
            player.release()
            release()
        }
        super.onDestroy()
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        val player = mediaSession?.player
        if (player?.playWhenReady == true) player.pause()
        stopSelf()
    }

    override fun onGetSession(
        controllerInfo: MediaSession.ControllerInfo
    ): MediaSession? = mediaSession

    @OptIn(UnstableApi::class)
    private fun createExoPlayerInstance(token: String): ExoPlayer {
        val dataSourceFactory =
            DefaultHttpDataSource
                .Factory()
                .apply {
                    setDefaultRequestProperties(
                        mapOf("Cookie" to "identity=$token")
                    )
                }

        return ExoPlayer
            .Builder(applicationContext)
            .setHandleAudioBecomingNoisy(true)
            .setMediaSourceFactory(DefaultMediaSourceFactory(dataSourceFactory))
            .build()
            .apply { playWhenReady = true }
    }

    private fun createMediaSession(player: ExoPlayer): MediaSession {
        return MediaSession
            .Builder(applicationContext, player)
            .build()
    }

    var exoPlayerInstance: ExoPlayer? = null
        private set
    private var mediaSession: MediaSession? = null
}
