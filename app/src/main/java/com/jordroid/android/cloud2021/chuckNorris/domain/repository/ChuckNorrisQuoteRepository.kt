package com.jordroid.android.cloud2021.chuckNorris.domain.repository

import androidx.lifecycle.LiveData
import com.jordroid.android.cloud2021.chuckNorris.domain.model.ChuckNorrisDomain

interface ChuckNorrisQuoteRepository {

    // Get all ChuckNorris quote from database
    fun selectAll(): LiveData<List<ChuckNorrisDomain>>

    // Delete all content in the table
    suspend fun deleteAll()

    // Fetch a new quote randomly and add it inside database
    suspend fun fetchData()
}