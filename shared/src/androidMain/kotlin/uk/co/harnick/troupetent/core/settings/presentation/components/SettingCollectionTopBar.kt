package uk.co.harnick.troupetent.core.settings.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.settings_backup_restore
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection
import uk.co.harnick.troupetent.core.settings.presentation.SettingsEvent
import uk.co.harnick.troupetent.core.settings.presentation.SettingsEvent.Screen.ClearCollection
import uk.co.harnick.troupetent.core.ui.presentation.components.NavigationBackArrow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingCollectionTopBar(
    collection: SettingCollection,
    settingsEvent: (SettingsEvent) -> Unit
) {
    TopAppBar(
        title = { Text(collection.title) },
        navigationIcon = { NavigationBackArrow() },
        actions = {
            IconButton(
                onClick = { settingsEvent(ClearCollection(collection)) }
            ) {
                Icon(
                    painterResource(Res.drawable.settings_backup_restore),
                    contentDescription = "Clear ${collection.title.lowercase()} settings"
                )
            }
        }
    )
}
