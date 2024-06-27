package uk.co.harnick.troupetent.common.navigation.presentation.components.expandablenavrail

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Hand
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.menu_open
import uk.co.harnick.troupetent.common.navigation.domain.model.Destination
import uk.co.harnick.troupetent.core.settings.presentation.SettingsScreen

@Composable
fun ExpandableRail() {
    var sheetIsExpanded by remember { mutableStateOf(false) }
    var sheetExpansionFinished by remember { mutableStateOf(false) }
    val width by animateDpAsState(
        targetValue = if (sheetIsExpanded) 200.dp else 80.dp,
        finishedListener = { sheetExpansionFinished = sheetIsExpanded }
    )
    val toggleIconRotation by animateFloatAsState(if (sheetIsExpanded) 0F else 180F)

    Column(
        modifier = Modifier
            .width(width)
            .padding(start = 12.dp, top = 18.dp, end = 12.dp, bottom = 20.dp),
        horizontalAlignment = Start,
        verticalArrangement = spacedBy(18.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(start = 4.dp)
                .clip(CircleShape)
                .size(48.dp)
                .clickable { sheetIsExpanded = !sheetIsExpanded }
                .pointerHoverIcon(Hand),
            contentAlignment = Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.menu_open),
                contentDescription = "Toggle navigation sheet",
                modifier = Modifier.rotate(toggleIconRotation)
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = spacedBy(12.dp)
        ) {
            listOf(Destination.Profile, Destination.Library).forEach {
                ExpandableRailItem(it, sheetIsExpanded, sheetExpansionFinished)
            }

            Spacer(modifier = Modifier.weight(1F))

            ExpandableRailItem(Destination.Settings, sheetIsExpanded, sheetExpansionFinished)
        }
    }
}
