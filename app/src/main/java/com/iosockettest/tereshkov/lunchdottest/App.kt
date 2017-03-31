package com.iosockettest.tereshkov.lunchdottest

import android.app.Application
import com.iosockettest.tereshkov.lunchdottest.dependencies.AppComponent
import com.iosockettest.tereshkov.lunchdottest.dependencies.AppModule
import com.iosockettest.tereshkov.lunchdottest.dependencies.DaggerAppComponent
import com.iosockettest.tereshkov.lunchdottest.dependencies.NetworkModule


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = buildAppComponent()
    }

    @Suppress("DEPRECATION")
    private fun buildAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }

    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }
}