package com.app

import android.app.Application
import com.app.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MyApp)
            modules(appComponent)
        }
    }
}