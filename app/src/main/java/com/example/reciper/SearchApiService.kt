package com.example.reciper

import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.spoonacular.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SearchApiService {
    @GET("food/menuItems/search?apiKey=30653edd10e243d29b4019e462618292&query=burger&number=1")
    suspend fun getProperties(): Menu
}

object SearchApi {
    val retrofitService : SearchApiService by lazy {
        retrofit.create(SearchApiService::class.java) }
}