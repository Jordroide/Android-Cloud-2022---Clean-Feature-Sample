package com.jordroid.android.cloud2021.chuckNorris.data.remote

import com.jordroid.android.cloud2021.chuckNorris.data.model.ChuckNorrisRetrofit
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {

    @GET("random")
    suspend fun getRandomQuote(): ChuckNorrisRetrofit
}