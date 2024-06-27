package uk.co.harnick.troupetent.core.settings.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.painterResource
import uk.co.harnick.troupetent.core.settings.domain.model.EnumSettingValue
import uk.co.harnick.troupetent.core.settings.domain.model.Setting
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection
import uk.co.harnick.troupetent.core.settings.presentation.SettingsEvent
import uk.co.harnick.troupetent.core.settings.presentation.SettingsEvent.Screen.UpdateCollection
import uk.co.harnick.troupetent.core.settings.presentation.components.valuereps.ColorValueRep
import uk.co.harnick.troupetent.core.settings.presentation.components.valuereps.EnumValueRep
import kotlin.reflect.full.primaryConstructor

@Suppress("UNCHECKED_CAST")
@Composable
fun Setting<*>.ToSettingEntry(
    collection: SettingCollection,
    settingsEvent: (SettingsEvent) -> Unit
) {
    fun onUpdate(newValue: Any) {
        val updatedSetting = this::class.primaryConstructor!!.call(newValue)
        settingsEvent(UpdateCollection(updatedSetting, collection))
    }

    var editorDialogIsVisible by remember { mutableStateOf(false) }

    ListItem(
        headlineContent = { Text(title) },
        modifier = Modifier.clickable {
            if (value is Boolean) onUpdate(!(value as Boolean))
            else editorDialogIsVisible = true
        },
        supportingContent = {
            Column {
                description?.let { Text(it) }
                warning?.let { Text("⚠ $it", color = MaterialTheme.colorScheme.error) }
            }
        },
        leadingContent = { Icon(painterResource(icon), contentDescription = null) },
        trailingContent = {
            when (value) {
                is Boolean -> Switch(value as Boolean, ::onUpdate)
                is Color -> ColorValueRep(value as Color, ::onUpdate)
                is EnumSettingValue -> EnumValueRep(
                    setting = this as Setting<EnumSettingValue>,
                    dialogIsVisible = editorDialogIsVisible,
                    onDismiss = { editorDialogIsVisible = false },
                    onUpdate = ::onUpdate
                )
            }
        }
    )
}
