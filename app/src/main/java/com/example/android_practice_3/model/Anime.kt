package com.example.android_practice_3.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Anime(
    val airing: Boolean,
    @Json(name = "end_date")
    val endDate: String?,
    val episodes: Int,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "mal_id")
    val malId: Int,
    val members: Int,
    val rated: String?,
    val score: Double,
    @Json(name = "start_date")
    val startDate: String?,
    val synopsis: String,
    val title: String,
    val type: String,
    val url: String
)