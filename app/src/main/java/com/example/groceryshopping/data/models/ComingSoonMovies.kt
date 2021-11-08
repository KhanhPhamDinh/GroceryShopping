package com.example.groceryshopping.data.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.FromJson
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

data class ComingSoonMovies(
    @Json(name = "items") val items: List<MovieComing>
)

@Parcelize
data class MovieComing(
    val id: String,
    val title: String,
    val fullTitle: String,
    val year: String,
    val releaseState: String,
    val image: String,
    val runtimeMins: String,
    val runtimeStr: String,
    val plot: String,
    val contentRating: String,
    val metacriticRating: String,
    val genres: String,
    //val genreList: String,
    val stars: String,
    val directors: String,
    @Json(name = "imDbRating") val imDbRating: String = "",
    @Json(name = "imDbRatingCount") val imDbRatingCount: String = ""
): Parcelable {
}