package uk.co.harnick.troupetent.common.servicelocator.modules

import android.content.Context
import uk.co.harnick.troupetent.core.util.NetworkUtils
import uk.co.harnick.troupetent.core.util.NetworkUtilsImpl

actual class UtilsModuleImpl(appContext: Context, coroutineModule: CoroutineModule) : UtilsModule {
    override val networkUtils: NetworkUtils =
        NetworkUtilsImpl(appContext, coroutineModule.mainDispatcher)
}
