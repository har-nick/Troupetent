package uk.co.harnick.troupetent.feature.library.presentation.components.topbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.more_vert
import uk.co.harnick.troupetent.common.navigation.domain.model.Destination

@Composable
fun LibraryActionMenu() {
    val navigator = LocalNavigator.currentOrThrow
    var isExpanded by remember { mutableStateOf(false) }

    Column {
        IconButton(
            onClick = { isExpanded = !isExpanded },
            content = {
                Icon(
                    painter = painterResource(Res.drawable.more_vert),
                    contentDescription = "Open menu"
                )
            }
        )

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            modifier = Modifier.padding(end = 40.dp)
        ) {
            DropdownMenuItem(
                text = { Text("Settings", style = MaterialTheme.typography.bodyLarge) },
                onClick = {
                    navigator.push(Destination.Settings.screenProvider())
                    isExpanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("About", style = MaterialTheme.typography.bodyLarge) },
                onClick = {
                    navigator.push(Destination.About.screenProvider())
                    isExpanded = false
                }
            )
        }
    }
}
