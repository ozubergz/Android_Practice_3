package com.example.android_practice_3.repo

import com.example.android_practice_3.model.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeService {

    @GET("anime")
    suspend fun getAnime(@Query("q") title : String) : Response<Result>

}