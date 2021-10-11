package com.example.groceryshopping.models

import java.util.*

data class TitleData(
    val id: String,
    val title: String,
    val originalTitle: String,
    val fullTitle: String,
    val type: String,
    val year: String,
    val image: String,
    val releaseDate: String,
    val runtimeMins: String,
    val runtimeStr: String,
    val plot: String,
    val plotLocal: String,
    val plotLocalIsRtl: Boolean,
    val awards: String,
    val directors: String,
    val directorList:  Array<ObjectIdName>,
    val writers: String,
    val writerList: Array<ObjectIdName>,
    val start: String,
    val startList: Array<ObjectIdName>,
    val actorList: Array<Actor>,
    val genres: String,
    val genreList: Array<ObjectKeyValue>,
    val companies: String,
    val companyList: Array<ObjectIdName>,
    val languages: String,
    val languageList: Array<ObjectKeyValue>,
    val contentRating : String,
    val imDbRating: String,
    val imDbRatingVotes: String,
    val metacriticRating: String,
    val boxOffice: BoxOffice,
    val tagline: String,
    val keywords: String,
    val keywordList: Array<String>,
    val similars: Array<Similars>,
    val errorMessage: String
    )


data class ObjectIdName(
    val id: String,
    val name: String
)

data class ObjectKeyValue(
    val key: String,
    val value: String
)

data class BoxOffice(
    val budget: String,
    val openingWeekendUSA: String,
    val grossUSA: String,
    val cumulativeWorldwideGross: String
)

data class Similars(
    val id: String,
    val title: String,
    val fullTitle: String,
    val year: String,
    val image: String,
    val plot: String,
    val directors: String,
    val stars: String,
    val genres: String,
    val imDbRating: String
)