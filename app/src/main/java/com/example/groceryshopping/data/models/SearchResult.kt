package com.example.groceryshopping.data.models

import com.squareup.moshi.Json

class SearchResult (
    @Json(name = "searchType") val searchType: String = "",
    @Json(name = "expression") val expression: String = "",
    @Json(name = "results") val results: List<SearchData>
    )


data class SearchData(val id: String,
                     val resultType: String,
                     val image: String,
                     val title: String,
                     val description: String)