package uk.co.harnick.troupetent.feature.library.domain.model

import org.jetbrains.compose.resources.DrawableResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.library_music_filled
import troupetent.shared.generated.resources.library_music_outlined
import troupetent.shared.generated.resources.queue_music

enum class LibraryTabs(val activeIcon: DrawableResource, val inactiveIcon: DrawableResource) {
    Library(
        activeIcon = Res.drawable.library_music_filled,
        inactiveIcon = Res.drawable.library_music_outlined
    ),
    Playlists(
        activeIcon = Res.drawable.queue_music,
        inactiveIcon = Res.drawable.queue_music
    )
}
