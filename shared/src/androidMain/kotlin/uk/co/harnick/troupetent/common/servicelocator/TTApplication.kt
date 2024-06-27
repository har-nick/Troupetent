package uk.co.harnick.troupetent.common.servicelocator

import android.app.Application

class TTApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceLocator.initialize(this)
    }
}
