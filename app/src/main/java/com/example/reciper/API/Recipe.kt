package com.example.reciper.API


import com.squareup.moshi.Json

data class Recipe(
    @Json(name = "results")
    val results: List<Result>,
    @Json(name = "number")
    val number: Int,
) {
    data class Result(
        @Json(name = "extendedIngredients")
        val extendedIngredients: List<ExtendedIngredient>,
        @Json(name = "id")
        val id: Int,
        @Json(name = "title")
        val title: String,
        @Json(name = "image")
        val image: String,
        @Json(name = "imageType")
        val imageType: String,
        @Json(name = "summary")
        val summary: String,
        @Json(name = "cuisines")
        val cuisines: List<String>,
    ) {
        data class ExtendedIngredient(
            @Json(name = "original")
            val original: String,
            @Json(name = "originalName")
            val originalName: String,
        )
        }
    }