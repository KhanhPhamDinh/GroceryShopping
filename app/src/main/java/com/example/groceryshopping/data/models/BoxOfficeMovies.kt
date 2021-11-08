package com.example.groceryshopping.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


data class BoxOfficeMovies(
    @Json(name = "items") val items: List<MovieOffice>
)


@Parcelize
data class MovieOffice(
    val id : String,
    @Json(name = "rank") val rank: String = "0",
    val title: String,
    val image: String,
    val weekend: String,
    val gross: String,
    val weeks: String
) : Parcelable {
}