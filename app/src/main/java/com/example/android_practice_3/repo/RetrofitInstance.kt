package com.example.android_practice_3.repo

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

//    https://api.jikan.moe/v3/search/anime?q=naruto

    private const val BASE_URL = "https://api.jikan.moe/v3/search/"

    private val client = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }.let {
        OkHttpClient.Builder().addInterceptor(it).build()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    val animeService: AnimeService by lazy {
        retrofit.create(AnimeService::class.java)
    }
}