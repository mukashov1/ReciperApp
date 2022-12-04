package com.example.reciper


import com.squareup.moshi.Json

data class Menu(
    @Json(name = "menuItems")
    val menuItems: List<MenuItem>
) {
    data class MenuItem(
        @Json(name = "id")
        val id: Int,
        @Json(name = "image")
        val image: String,
        @Json(name = "imageType")
        val imageType: String,
        @Json(name = "title")
        val title: String
    )
}