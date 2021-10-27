package com.example.groceryshopping.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    val id: String,
    @Json(name = "rank") val rank: String = "0",
    @Json(name = "rankUpDown") val rankUpDown: String = "0",
    val title: String,
    val fullTitle: String,
    val year: String,
    val image: String,
    val crew: String,
    @Json(name = "plot") val plot: String = "",
    @Json(name = "genres") val genres: String = "",
    val imDbRating: String,
    val imDbRatingCount: String
): Parcelable {
}
