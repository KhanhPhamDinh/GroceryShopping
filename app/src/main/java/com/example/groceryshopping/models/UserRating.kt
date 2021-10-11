package com.example.groceryshopping.models

data class UserRating(
    val imDbId: String,
    val title: String,
    val fullitle: String,
    val type: String,
    val year: String,
    val totalRating: String,
    val totalRatingVotes: String,
    val rating: Array<ratingDetail>,
    val errorMessage: String,
)

data class ratingDetail(
    val rating: String,
    val percent: String,
    val votes: String
)