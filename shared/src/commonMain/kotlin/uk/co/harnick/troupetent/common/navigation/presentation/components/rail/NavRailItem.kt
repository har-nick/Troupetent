package uk.co.harnick.troupetent.common.navigation.presentation.components.rail

import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uk.co.harnick.troupetent.common.navigation.domain.model.Destination
import uk.co.harnick.troupetent.common.navigation.presentation.components.CrossfadeIcon

@Composable
fun Destination.ToNavRailItem(modifier: Modifier = Modifier) {
    val navigator = LocalNavigator.currentOrThrow

    val isSelected = this == navigator.lastItem
    val imageVector = if (isSelected) icon?.active else icon?.inactive

    NavigationRailItem(
        selected = isSelected,
        onClick = { navigator.replaceAll(screenProvider()) },
        modifier = modifier.then(Modifier.pointerHoverIcon(PointerIcon.Hand)),
        icon = { imageVector?.let { CrossfadeIcon(it) } },
        label = { label?.let { Text(it) } },
        alwaysShowLabel = false
    )
}
