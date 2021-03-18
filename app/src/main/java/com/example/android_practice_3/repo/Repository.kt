package com.example.android_practice_3.repo

import com.example.android_practice_3.model.Result
import retrofit2.Response

object Repository {

    private val animeService = RetrofitInstance.animeService

    suspend fun getAnime(title: String) : Response<Result> {
        return animeService.getAnime(title)
    }
}