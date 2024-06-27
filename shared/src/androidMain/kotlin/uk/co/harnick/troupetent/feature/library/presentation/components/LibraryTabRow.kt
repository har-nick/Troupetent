package uk.co.harnick.troupetent.feature.library.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.ExperimentalResourceApi
import uk.co.harnick.troupetent.common.navigation.presentation.components.CrossfadeIcon
import uk.co.harnick.troupetent.feature.library.domain.model.LibraryTabs

@OptIn(ExperimentalFoundationApi::class, ExperimentalResourceApi::class)
@Composable
fun LibraryTabRow(pagerState: PagerState, onTabSwitch: (Int) -> Unit) {
    val currentPageIndex = pagerState.currentPage
    val settledPageIndex = pagerState.settledPage
    val scrollOffset = pagerState.currentPageOffsetFraction

    TabRow(
        selectedTabIndex = settledPageIndex,
        indicator = { tabPositions ->
            ScrollingTabIndicator(tabPositions[currentPageIndex], scrollOffset)
        }
    ) {
        LibraryTabs.entries.forEach { page ->
            val isSelected = currentPageIndex == page.ordinal
            val icon = if (isSelected) page.activeIcon else page.inactiveIcon

            LeadingIconTab(
                selected = isSelected,
                onClick = { onTabSwitch(page.ordinal) },
                text = { Text(page.name) },
                icon = { CrossfadeIcon(icon) },
                unselectedContentColor = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
