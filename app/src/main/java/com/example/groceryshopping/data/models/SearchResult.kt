package com.example.groceryshopping.data.models

class SearchResult (val searchType: String,
                    val expression: String,
                    val result: Array<SearchData>,
                    val errorMessage: String)


data class SearchData(val id: String,
                     val resultType: String,
                     val image: String,
                     val title: String,
                     val description: String)