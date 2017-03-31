package com.iosockettest.tereshkov.lunchdottest.presentation.restaurants

import com.iosockettest.tereshkov.lunchdottest.data.Restaurant
import com.iosockettest.tereshkov.lunchdottest.presentation.BaseView


interface RestaurantView : BaseView {
    fun startLoading()
    fun stopLoading()
    fun setData(data: List<Restaurant>)
}