package com.example.groceryshopping.data.api

import com.example.groceryshopping.data.models.SearchResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL =
    "https://imdb-api.com/en/"


/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [SearchNameService] method
 */
interface SearchNameService {
    @GET("API/SearchName")
    fun getName(@Query("APIKey") type: String): Call<SearchResult>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object SearchNameApi {
    val retrofitService : SearchNameService by lazy { retrofit.create(SearchNameService::class.java) }
}
