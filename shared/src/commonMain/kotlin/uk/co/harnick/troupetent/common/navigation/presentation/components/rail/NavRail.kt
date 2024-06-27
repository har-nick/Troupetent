package uk.co.harnick.troupetent.common.navigation.presentation.components.rail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationRail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.harnick.troupetent.common.navigation.domain.model.Destination.Profile
import uk.co.harnick.troupetent.core.ui.presentation.Insets

@Composable
fun NavRail() {
    NavigationRail(
        modifier = Modifier.padding(top = Insets.displayCutout)
    ) {
        Box(
            modifier = Modifier.fillMaxHeight(),
            contentAlignment = Center
        ) {
            Column(
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
                content = { listOf(Profile).forEach { it.ToNavRailItem() } }
            )
        }
    }
}
