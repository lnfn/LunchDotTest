package com.iosockettest.tereshkov.lunchdottest.domain.restaurants

import com.iosockettest.tereshkov.lunchdottest.data.Restaurant
import com.iosockettest.tereshkov.lunchdottest.network.APIWebService
import com.iosockettest.tereshkov.lunchdottest.network.LaunchDotResponse
import com.iosockettest.tereshkov.lunchdottest.network.ListMeta
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class RestaurantsInteractor @Inject constructor(
        private val apiWebService: APIWebService
) {

    fun getRestaurants(): Observable<LaunchDotResponse<List<Restaurant>, ListMeta>> = apiWebService
            .getRestaurants()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}