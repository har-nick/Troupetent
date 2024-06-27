package uk.co.harnick.troupetent.common.navigation.domain.model

import cafe.adriel.voyager.core.screen.Screen
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.library_music_filled
import troupetent.shared.generated.resources.library_music_outlined
import troupetent.shared.generated.resources.person_filled
import troupetent.shared.generated.resources.person_outlined
import troupetent.shared.generated.resources.settings_filled
import troupetent.shared.generated.resources.settings_outlined
import uk.co.harnick.troupetent.Account
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.ProfileScreen
import uk.co.harnick.troupetent.core.settings.presentation.SettingsScreen
import uk.co.harnick.troupetent.feature.library.presentation.LibraryScreen
import uk.co.harnick.troupetent.feature.onboarding.presentation.OnboardingScreen

sealed class Destination(
    val screenProvider: () -> Screen,
    val icon: DestinationIcon? = null,
    val label: String? = null
) {
    data object About : Destination(
        screenProvider = { SettingsScreen },
        icon = DestinationIcon(
            active = Res.drawable.person_filled,
            inactive = Res.drawable.person_outlined
        ),
        label = "About"
    )

    data object Profile : Destination(
        screenProvider = { ProfileScreen },
        icon = DestinationIcon(
            active = Res.drawable.person_filled,
            inactive = Res.drawable.person_outlined
        ),
        label = "Account"
    )

    data class Library(private val account: Account) : Destination(
        screenProvider = { LibraryScreen },
        icon = DestinationIcon(
            active = Res.drawable.library_music_filled,
            inactive = Res.drawable.library_music_outlined
        ),
        label = "Library"
    )

    data object Onboarding : Destination(screenProvider = { OnboardingScreen })

    data object Settings : Destination(
        screenProvider = { SettingsScreen },
        icon = DestinationIcon(
            active = Res.drawable.settings_filled,
            inactive = Res.drawable.settings_outlined
        ),
        label = "Settings"
    )
}
