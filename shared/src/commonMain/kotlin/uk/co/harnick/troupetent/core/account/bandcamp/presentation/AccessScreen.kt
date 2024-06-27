package uk.co.harnick.troupetent.core.account.bandcamp.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.multiplatform.webview.jsbridge.rememberWebViewJsBridge
import com.multiplatform.webview.web.LoadingState.Finished
import com.multiplatform.webview.web.LoadingState.Loading
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewState
import kotlinx.coroutines.delay
import uk.co.harnick.bandkit.data.remote.api.BandKit.Common.BASE_URL
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator
import uk.co.harnick.troupetent.core.account.bandcamp.domain.model.AccountAccessMethod
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountEvent.AccessMethodInteraction.ClearMethod
import uk.co.harnick.troupetent.core.account.bandcamp.presentation.AccountEvent.Login
import uk.co.harnick.troupetent.core.ui.presentation.BackHandler
import uk.co.harnick.troupetent.core.ui.presentation.Insets

class AccessScreen(
    private val intent: AccountAccessMethod,
    private val loginVerificationUrl: String? = null
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val accountViewModel = ServiceLocator.viewModelModule.accountViewModel
        val accountState by accountViewModel.state.collectAsState()
        val accountEvent = accountViewModel::onEvent

        val snackbarHostState = remember { SnackbarHostState() }

        val initialUrl = loginVerificationUrl ?: intent.initialUrl
        val webViewAlpha = remember { Animatable(0F) }
        val webViewJsBridge = rememberWebViewJsBridge()
        val webViewState = rememberWebViewState(initialUrl)


        BackHandler {
            accountEvent(ClearMethod)
            navigator.pop()
        }

        val topPadding = Insets.statusBar.value.toInt()
        val bottomPadding = Insets.navigationBar.value.toInt()

        // Padding around the DOM makes things look a little nicer
        fun insertPaddingToDOM() {
            webViewJsBridge.webView?.evaluateJavaScript(
                """
                    var mainWrapper = document.querySelector("#propOpenWrapper");
                    var footer = document.querySelector(".pg-ft-mobile > .col");
                    mainWrapper.style.paddingTop = '${topPadding}px'
                    footerBackground.style.paddingBottom = '${bottomPadding}px'
                """
            )
        }

        LaunchedEffect(accountState.error) {
            accountState.error?.let {
                snackbarHostState.showSnackbar(it)
            }
        }

        LaunchedEffect(webViewState.loadingState) {
            if (webViewState.loadingState is Loading) {
                webViewAlpha.animateTo(0F)
            } else {
                if (webViewState.lastLoadedUrl == initialUrl) {
                    insertPaddingToDOM()
                    delay(1000L)
                    webViewAlpha.animateTo(1F)
                }
            }
        }

        LaunchedEffect(webViewState.loadingState, webViewState.lastLoadedUrl) {
            if (webViewState.loadingState is Finished) {
                webViewState.cookieManager.getCookies(BASE_URL)
                    .find { it.name == "identity" }
                    ?.let { accountEvent(Login(it.value)) }
            }
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = { SnackbarHost(snackbarHostState) },
            containerColor = MaterialTheme.colorScheme.surface
        ) { insets ->
            WebView(
                state = webViewState,
                modifier = Modifier
                    .alpha(webViewAlpha.value)
                    .fillMaxSize(),
                captureBackPresses = false,
                webViewJsBridge = webViewJsBridge
            )
        }
    }
}
