package com.iosockettest.tereshkov.lunchdottest.dependencies

import com.iosockettest.tereshkov.lunchdottest.presentation.restaurants.RestaurantsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
    fun inject(restaurantsActivity: RestaurantsActivity)
}