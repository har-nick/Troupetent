package uk.co.harnick.troupetent.core.settings.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import uk.co.harnick.troupetent.core.settings.domain.model.SettingCollection

@Composable
fun SettingCollection.ToCollectionEntry(onNavigate: () -> Unit) {
    ListItem(
        headlineContent = { Text(text = title, style = MaterialTheme.typography.titleMedium) },
        modifier = Modifier.clickable { onNavigate() },
        supportingContent = { Text(text = summary) },
        leadingContent = { Icon(painter = painterResource(icon), contentDescription = null) }
    )
}
