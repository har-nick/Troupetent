package uk.co.harnick.troupetent.feature.library.presentation.components.library

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells.Adaptive
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.harnick.troupetent.core.ui.presentation.Insets
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent
import uk.co.harnick.troupetent.feature.library.presentation.LibraryState

@Composable
fun LibraryItemGrid(
    params: LibraryState.ItemGridParams,
    libraryEvent: (LibraryEvent) -> Unit
) {
    val gridState = rememberLazyGridState()

    @SuppressLint("FrequentlyChangedStateReadInComposition")
    val lastItemVisible by remember(gridState.firstVisibleItemIndex, params.libraryItems) {
        val lastItemIndex = gridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
        val itemCount = gridState.layoutInfo.totalItemsCount - 1
        derivedStateOf { lastItemIndex == itemCount }
    }

    LaunchedEffect(params.hasQueuedTracks) {
        if (params.hasQueuedTracks && lastItemVisible) {
            val lastItemIndex = gridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
            lastItemIndex?.let { gridState.animateScrollToItem(it) }
        }
    }

    LazyVerticalGrid(
        columns = Adaptive(minSize = 100.dp),
        modifier = Modifier.fillMaxSize(),
        state = gridState,
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp, bottom = Insets.navigationBar),
        horizontalArrangement = spacedBy(8.dp),
        verticalArrangement = spacedBy(8.dp)
    ) {
        item(key = 0, span = { GridItemSpan(maxLineSpan) }) {
            // Grid scrolls to the first key when reordering. An unmoved dummy item prevents this
            // TODO: Check https://issuetracker.google.com/issues/209652366 in another year
        }

        params.libraryItems?.let { items ->
            items(items, key = { it.id }) { item ->
                LibraryItem(libraryEvent, item)
            }
        }

        // Pad list to prevent obscured content by player
        item(span = { GridItemSpan(maxLineSpan) }) {
            if (params.hasQueuedTracks) Spacer(Modifier.height(84.dp))
        }
    }
}
