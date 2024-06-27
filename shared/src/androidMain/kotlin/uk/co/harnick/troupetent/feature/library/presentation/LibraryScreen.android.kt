package uk.co.harnick.troupetent.feature.library.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import uk.co.harnick.troupetent.Account
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator
import uk.co.harnick.troupetent.feature.library.domain.model.LibraryTabs
import uk.co.harnick.troupetent.feature.library.presentation.components.LibraryContentPager
import uk.co.harnick.troupetent.feature.library.presentation.components.playerwidget.FloatingPlayerWidget
import uk.co.harnick.troupetent.feature.library.presentation.components.topbar.LibraryHeader

@OptIn(ExperimentalFoundationApi::class)
actual class LibraryScreen actual constructor(private val account: Account) : Screen {
    // Transition crashes without this since K2. No idea why.
    override val key = uniqueScreenKey

    @Composable
    override fun Content() {
        val accountState by ServiceLocator.viewModelModule.accountViewModel.state.collectAsState()

        val libraryViewModel = rememberScreenModel {
            LibraryViewModel(
                currentAccount = account,
                ioDispatcher = ServiceLocator.coroutineModule.ioDispatcher,
                libraryRepo = ServiceLocator.repoBindings.libraryRepo,
                libraryUseCases = ServiceLocator.useCaseModule.libraryUseCases
            )
        }
        val libraryState by libraryViewModel.state.collectAsState()
        val libraryEvent = libraryViewModel::onEvent
        val pagerState = rememberPagerState(pageCount = { LibraryTabs.entries.size })

        Scaffold(
            topBar = { LibraryHeader(accountState.currentAccount, libraryState.history) }
        ) { scaffoldPadding ->
            LibraryContentPager(libraryState, pagerState, scaffoldPadding, libraryEvent)
            FloatingPlayerWidget(libraryState.playerWidgetParams, libraryEvent)
        }
    }
}
