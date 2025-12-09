package com.procurify.interview

import android.app.Application
import com.procurify.interview.di.appModules
import com.procurify.interview.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(networkModule, appModules)
        }
    }
}