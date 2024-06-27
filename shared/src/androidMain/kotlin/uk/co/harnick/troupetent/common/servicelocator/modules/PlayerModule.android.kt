package uk.co.harnick.troupetent.common.servicelocator.modules

import android.content.Context

actual interface PlayerModule {
}

actual class PlayerModuleImpl(private val appContext: Context) : PlayerModule {
}
