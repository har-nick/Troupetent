package uk.co.harnick.troupetent.feature.library.presentation.components.library

import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent.UI.RefreshData
import uk.co.harnick.troupetent.feature.library.presentation.LibraryState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LibraryPage(
    libraryIsRefreshing: Boolean,
    gridParams: LibraryState.ItemGridParams,
    libraryEvent: (LibraryEvent) -> Unit
) {
    val refreshState = rememberPullRefreshState(
        refreshing = libraryIsRefreshing,
        onRefresh = { libraryEvent(RefreshData) }
    )

    Box(
        modifier = Modifier.pullRefresh(refreshState),
        contentAlignment = Alignment.TopCenter
    ) {
        LibraryItemGrid(gridParams, libraryEvent)
        PullRefreshIndicator(libraryIsRefreshing, refreshState)
    }
}
