package uk.co.harnick.troupetent.core.util

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.net.NetworkRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import uk.co.harnick.troupetent.common.servicelocator.modules.MainDispatcher

class NetworkUtilsImpl(appContext: Context, mainDispatcher: MainDispatcher) : NetworkUtils {
    private val networkUtilsScope = CoroutineScope(mainDispatcher)
    private val connectivityManager =
        appContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

    private val _networkIsAvailable = Channel<Boolean>()
    override val networkIsAvailable: Flow<Boolean> =
        _networkIsAvailable.receiveAsFlow().distinctUntilChanged()

    private val networkStatusCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            networkUtilsScope.launch { _networkIsAvailable.send(true) }
        }

        override fun onBlockedStatusChanged(network: Network, blocked: Boolean) {
            networkUtilsScope.launch { _networkIsAvailable.send(!blocked) }
        }

        override fun onLost(network: Network) {
            networkUtilsScope.launch { _networkIsAvailable.send(false) }
        }

        override fun onUnavailable() {
            networkUtilsScope.launch { _networkIsAvailable.send(false) }
        }
    }
    private val networkStatusRequest = NetworkRequest.Builder()
        .addCapability(NET_CAPABILITY_INTERNET)
        .build()

    init {
        connectivityManager.registerNetworkCallback(networkStatusRequest, networkStatusCallback)
    }
}
