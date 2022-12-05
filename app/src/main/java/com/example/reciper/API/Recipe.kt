package com.example.reciper.API


import com.squareup.moshi.Json

data class Recipe(
    @Json(name = "results")
    val results: List<Result>,
    @Json(name = "offset")
    val offset: Int,
    @Json(name = "number")
    val number: Int,
    @Json(name = "totalResults")
    val totalResults: Int
) {
    data class Result(
        @Json(name = "extendedIngredients")
        val extendedIngredients: List<ExtendedIngredient>,
        @Json(name = "id")
        val id: Int,
        @Json(name = "title")
        val title: String,
        @Json(name = "sourceUrl")
        val sourceUrl: String,
        @Json(name = "image")
        val image: String,
        @Json(name = "summary")
        val summary: String,
        @Json(name = "cuisines")
        val cuisines: List<String>,
    ) {
        data class ExtendedIngredient(
            @Json(name = "id")
            val id: Int,
            @Json(name = "name")
            val name: String,
            @Json(name = "original")
            val original: String,
        )

    }
}