package com.example.groceryshopping.data.models

import com.squareup.moshi.Json

data class MostPopularMovies(
    @Json(name = "items") val items: List<Movies>
)
