package com.iosockettest.tereshkov.lunchdottest.network

import com.iosockettest.tereshkov.lunchdottest.data.Restaurant
import io.reactivex.Observable
import retrofit2.http.GET


interface APIWebService {
    @GET("restaurant")
    fun getRestaurants(): Observable<LaunchDotResponse<List<Restaurant>, ListMeta>>
}