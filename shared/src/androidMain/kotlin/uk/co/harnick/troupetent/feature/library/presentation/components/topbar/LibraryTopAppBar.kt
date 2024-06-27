package uk.co.harnick.troupetent.feature.library.presentation.components.topbar

import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.harnick.bandkit.data.model.Track
import uk.co.harnick.troupetent.Account
import uk.co.harnick.troupetent.core.ui.presentation.Insets

@Composable
fun LibraryHeader(account: Account?, history: List<Track>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, top = Insets.statusBar, end = 12.dp),
        horizontalArrangement = SpaceBetween,
        verticalAlignment = CenterVertically
    ) {
        account?.let { LibraryAvatar(it.nickname ?: it.username, it.avatarId) }
        Row {
            LibraryHistory(history)
            LibraryActionMenu()
        }
    }
}
