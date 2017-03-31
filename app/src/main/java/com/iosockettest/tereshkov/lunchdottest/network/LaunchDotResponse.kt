package com.iosockettest.tereshkov.lunchdottest.network


data class LaunchDotResponse<D, M>(
        var data: D,
        var meta: M? = null
)

data class ListMeta(
        var current: Int,
        var perPage: Int,
        var total: Int
)