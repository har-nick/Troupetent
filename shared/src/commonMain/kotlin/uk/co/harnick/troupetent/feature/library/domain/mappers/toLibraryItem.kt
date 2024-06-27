package uk.co.harnick.troupetent.feature.library.domain.mappers

import uk.co.harnick.troupetent.LibraryItem
import java.time.ZonedDateTime
import uk.co.harnick.bandkit.data.model.LibraryItem as BandKitItem

fun BandKitItem.toLibraryItem(ownerId: Long): LibraryItem =
    LibraryItem(
        artist = artist,
        artId = artId,
        dateTimePurchased = ZonedDateTime.parse(dateTimePurchased),
        dateTimeReleased = ZonedDateTime.parse(dateTimeReleased),
        downloadLink = downloadUrl,
        favoriteTrackId = favoriteTrackId,
        id = id,
        ownerId = ownerId,
        trackList = tracklist,
        title = title,
        type = type
    )
