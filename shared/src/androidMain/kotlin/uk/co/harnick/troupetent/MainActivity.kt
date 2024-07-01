package uk.co.harnick.troupetent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import uk.co.harnick.troupetent.core.Troupetent

private fun MainActivity.installSplashscreen(onScreenCondition: Boolean) {
    installSplashScreen()
        .apply {
            setKeepOnScreenCondition { onScreenCondition }
        }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashscreen(false)
        setContent {
            Troupetent()
        }
    }
}
