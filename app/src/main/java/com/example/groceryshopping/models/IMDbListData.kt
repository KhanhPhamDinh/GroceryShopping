package com.example.groceryshopping.models

data class IMDbListData(
    val title: String,
    val by: String,
    val created: String,
    val updated: String,
    val description: String,
    val items: Array<IMDBListDataDetail>,
    val errorMessage: String,
)

data class IMDBListDataDetail(
    val id: String,
    val index: String,
    val title: String,
    val fullTitle: String,
    val year: String,
    val image: String,
    val imDbRating: String,
    val imDbRatingCount: String,
    val description: String
)