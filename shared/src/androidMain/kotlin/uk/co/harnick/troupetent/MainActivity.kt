package uk.co.harnick.troupetent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import uk.co.harnick.troupetent.common.servicelocator.ServiceLocator
import uk.co.harnick.troupetent.core.Troupetent

class MainActivity : ComponentActivity() {
    private fun installSplashscreen() {
        installSplashScreen()
            .apply {
                setKeepOnScreenCondition {
                    ServiceLocator.viewModelModule.accountViewModel.state.value.isLoadingAccounts
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashscreen()
        setContent {
            Troupetent()
        }
    }
}
