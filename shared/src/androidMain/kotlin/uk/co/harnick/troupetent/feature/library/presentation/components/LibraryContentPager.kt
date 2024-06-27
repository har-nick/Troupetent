package uk.co.harnick.troupetent.feature.library.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import uk.co.harnick.troupetent.feature.library.presentation.LibraryEvent
import uk.co.harnick.troupetent.feature.library.presentation.LibraryState
import uk.co.harnick.troupetent.feature.library.presentation.components.library.LibraryPage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LibraryContentPager(
    libraryState: LibraryState,
    pagerState: PagerState,
    scaffoldPadding: PaddingValues,
    libraryEvent: (LibraryEvent) -> Unit
) {
    val pagerScope = rememberCoroutineScope()
    fun animateToPage(index: Int) = pagerScope.launch {
        pagerState.animateScrollToPage(
            page = index.coerceIn(0 until pagerState.pageCount)
        )
    }

    Column(
        Modifier.padding(top = scaffoldPadding.calculateTopPadding())
    ) {
        LibraryTabRow(pagerState, ::animateToPage)
        HorizontalPager(
            state = pagerState,
            beyondBoundsPageCount = 1,
            pageSpacing = 20.dp,
            flingBehavior = PagerDefaults.flingBehavior(
                state = pagerState,
                snapPositionalThreshold = 0.2F
            )
        ) { index ->
            when (index) {
                0 -> LibraryPage(libraryState.libraryIsRefreshing, libraryState.itemGridParams, libraryEvent)
                1 -> {}
            }
        }
    }
}
