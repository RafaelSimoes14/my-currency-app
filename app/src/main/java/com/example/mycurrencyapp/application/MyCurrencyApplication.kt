package com.example.mycurrencyapp.application

import android.app.Application
import com.example.mycurrencyapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyCurrencyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyCurrencyApplication)
            modules(appModules)
        }
    }
}