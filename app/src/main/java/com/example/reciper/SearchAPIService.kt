package com.example.reciper

import com.example.reciper.API.Recipe
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.spoonacular.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SearchApiService {
    @GET("recipes/complexSearch?apiKey=026650c07a2848098b13a3adc1afb378&number=6&fillIngredients=true&addRecipeInformation=true")
    suspend fun getProperties(
        @Query("query")
        query: String
    ): Recipe
}

object SearchApi {
    val retrofitService : SearchApiService by lazy {
        retrofit.create(SearchApiService::class.java) }
}