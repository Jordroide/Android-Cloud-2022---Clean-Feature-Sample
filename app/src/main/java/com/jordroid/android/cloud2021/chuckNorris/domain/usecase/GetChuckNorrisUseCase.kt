package com.jordroid.android.cloud2021.chuckNorris.domain.usecase

import androidx.lifecycle.LiveData
import com.jordroid.android.cloud2021.chuckNorris.data.repository.ChuckNorrisQuoteRepositoryImpl
import com.jordroid.android.cloud2021.chuckNorris.domain.model.ChuckNorrisDomain
import com.jordroid.android.cloud2021.chuckNorris.domain.repository.ChuckNorrisQuoteRepository

class GetChuckNorrisUseCase {
    private val chuckNorrisQuoteRepository: ChuckNorrisQuoteRepository by lazy { ChuckNorrisQuoteRepositoryImpl() }

    fun selectAll(): LiveData<List<ChuckNorrisDomain>> {
        return chuckNorrisQuoteRepository.selectAll()
    }
}

