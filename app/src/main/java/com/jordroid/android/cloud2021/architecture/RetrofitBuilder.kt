package com.jordroid.android.cloud2021.architecture

import com.google.gson.GsonBuilder
import com.jordroid.android.cloud2021.chuckNorris.data.remote.ChuckNorrisQuoteEndpoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    // Create an instance of retrofit
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    fun getChuckNorrisQuote(): ChuckNorrisQuoteEndpoint =
        retrofit.create(ChuckNorrisQuoteEndpoint::class.java)
}