package com.jordroid.android.cloud2021.chuckNorris.domain.usecase

import com.jordroid.android.cloud2021.chuckNorris.data.repository.ChuckNorrisQuoteRepositoryImpl
import com.jordroid.android.cloud2021.chuckNorris.domain.repository.ChuckNorrisQuoteRepository

class DeleteAllChuckNorrisUseCase {

    private val chuckNorrisQuoteRepository: ChuckNorrisQuoteRepository by lazy { ChuckNorrisQuoteRepositoryImpl() }

    suspend fun deleteAll() {
        chuckNorrisQuoteRepository.deleteAll()
    }
}