package uk.co.harnick.troupetent.core.settings.presentation.components.valuereps

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.arrow_forward_ios
import uk.co.harnick.troupetent.core.settings.domain.model.EnumSettingValue
import uk.co.harnick.troupetent.core.settings.domain.model.Setting

@Composable
fun EnumValueRep(
    setting: Setting<EnumSettingValue>,
    dialogIsVisible: Boolean,
    onDismiss: () -> Unit,
    onUpdate: (EnumSettingValue) -> Unit
) {
    var selectedValue by remember { mutableStateOf(setting.value) }

    // Prevents dialog remembering chosen but not saved values after dismissal
    LaunchedEffect(dialogIsVisible) {
        if (dialogIsVisible) selectedValue = setting.value
    }

    Box {
        Icon(
            painter = painterResource(Res.drawable.arrow_forward_ios),
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )

        AnimatedVisibility(dialogIsVisible) {
            AlertDialog(
                onDismissRequest = onDismiss,
                confirmButton = {
                    TextButton(
                        onClick = { onUpdate(selectedValue) },
                        content = { Text("Confirm") }
                    )
                },
                dismissButton = {
                    TextButton(
                        onClick = onDismiss,
                        content = { Text("Dismiss") }
                    )
                },
                icon = { Icon(painter = painterResource(setting.icon), contentDescription = null) },
                title = { Text(setting.title) },
                text = {
                    LazyColumn {
                        items(setting.value::class.java.enumConstants) { enum ->
                            Row(
                                modifier = Modifier
                                    .clip(MaterialTheme.shapes.extraLarge)
                                    .fillMaxWidth()
                                    .clickable { selectedValue = enum },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = (selectedValue == enum),
                                    onClick = { selectedValue = enum }
                                )
                                Text(text = enum.label, style = MaterialTheme.typography.labelLarge)
                            }
                        }
                    }
                }
            )
        }
    }
}
