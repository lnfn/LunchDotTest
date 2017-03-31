package com.iosockettest.tereshkov.lunchdottest.presentation.restaurants

import com.iosockettest.tereshkov.lunchdottest.presentation.BaseView


abstract class BasePresenter<V : BaseView> {
    var view: V? = null

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        view = null
    }

    abstract fun onStart()
    abstract fun onStop()
}