package com.iosockettest.tereshkov.lunchdottest.dependencies

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class AppModule(private val application: Application) {
    @Provides
    internal fun provideContext(): Context {
        return application.applicationContext
    }
}