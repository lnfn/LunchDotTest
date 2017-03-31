package com.iosockettest.tereshkov.lunchdottest.presentation.restaurants

import android.util.Log
import com.iosockettest.tereshkov.lunchdottest.domain.restaurants.RestaurantsInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class RestaurantPresenter @Inject constructor(
        private val restaurantsInteractor: RestaurantsInteractor
) : BasePresenter<RestaurantView>() {

    val subscription = CompositeDisposable()

    override fun onStart() {
        subscription.add(
                restaurantsInteractor.getRestaurants()
                        .doOnSubscribe { view?.startLoading() }
                        .doOnTerminate { view?.stopLoading() }
                        .subscribe(
                                { restaurants ->
                                    Log.d("restaurants", restaurants.toString())
                                    view?.setData(restaurants.data)
                                },
                                { error ->
                                    Log.d("restaurants", error.message?.let { it } ?: "error")
                                },
                                {}
                        )
        )
    }

    override fun onStop() {
        subscription.clear()
    }
}