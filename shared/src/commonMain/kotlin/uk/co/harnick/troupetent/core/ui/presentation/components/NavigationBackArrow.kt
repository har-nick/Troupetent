package uk.co.harnick.troupetent.core.ui.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import org.jetbrains.compose.resources.painterResource
import troupetent.shared.generated.resources.Res
import troupetent.shared.generated.resources.arrow_back

@Composable
fun NavigationBackArrow(onBack: (() -> Unit)? = null) {
    val navigator = LocalNavigator.current

    IconButton(
        onClick = { onBack?.let { it() } ?: navigator?.pop() },
        content = {
            Icon(
                painter = painterResource(Res.drawable.arrow_back),
                contentDescription = "Go to the previous page"
            )
        }
    )
}
