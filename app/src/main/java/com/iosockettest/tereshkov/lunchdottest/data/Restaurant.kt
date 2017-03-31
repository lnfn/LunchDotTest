package com.iosockettest.tereshkov.lunchdottest.data

sealed class ItemList

data class Restaurant(
        var id: Long,
        var title: String,
        var address: String,
        var lat: Double,
        var lon: Double,
        var wifi: Boolean,
        var parking: Boolean,
        var distance: Double,
        var imageId: Long,
        var logoId: Long,
        var iconId: Long,
        var averageCheck: Int,
        var cuisine: String,
        var workingTime: String,
        var phone: String,
        var orderDelay: Int,
        var orderEnabled: Boolean,
        var menu: List<String>?,
        var constructorSections: String?,
        var menuCategories: String?
) : ItemList()

class ItemLoading : ItemList()