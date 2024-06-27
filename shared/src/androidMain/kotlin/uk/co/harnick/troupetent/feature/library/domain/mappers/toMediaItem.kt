package uk.co.harnick.troupetent.feature.library.domain.mappers

import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.MimeTypes
import uk.co.harnick.bandkit.data.model.Track

fun Track.toMediaItem(): MediaItem {
    val metadata =
        MediaMetadata.Builder()
            .setMediaType(MediaMetadata.MEDIA_TYPE_MUSIC)
            .setTitle(title)
            .setArtist(artist)
            .setTrackNumber(index)
            .build()

    return MediaItem
        .fromUri(adaptiveStreamUrl)
        .buildUpon()
        .setMimeType(MimeTypes.AUDIO_MPEG)
        .setMediaMetadata(metadata)
        .build()
}
