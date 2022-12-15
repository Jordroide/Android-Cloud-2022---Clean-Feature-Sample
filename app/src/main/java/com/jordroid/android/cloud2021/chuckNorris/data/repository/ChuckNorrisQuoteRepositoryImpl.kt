package com.jordroid.android.cloud2021.chuckNorris.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.jordroid.android.cloud2021.architecture.CustomApplication
import com.jordroid.android.cloud2021.architecture.RetrofitBuilder
import com.jordroid.android.cloud2021.chuckNorris.data.mapper.fromRoomToDomain
import com.jordroid.android.cloud2021.chuckNorris.data.mapper.toRoom
import com.jordroid.android.cloud2021.chuckNorris.data.model.ChuckNorrisRoom
import com.jordroid.android.cloud2021.chuckNorris.domain.model.ChuckNorrisDomain
import com.jordroid.android.cloud2021.chuckNorris.domain.repository.ChuckNorrisQuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChuckNorrisQuoteRepositoryImpl : ChuckNorrisQuoteRepository {
    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.chuckNorrisDao()

    override fun selectAll(): LiveData<List<ChuckNorrisDomain>> {
        return chuckNorrisDao.selectAll().map {
            it.fromRoomToDomain()
        }
    }

    override suspend fun deleteAll() = withContext(Dispatchers.IO) {
        chuckNorrisDao.deleteAll()
    }

    override suspend fun fetchData() {
        insertOnce(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }

    private suspend fun insertOnce(chuckNorrisQuote: ChuckNorrisRoom) =
        withContext(Dispatchers.IO) {
            chuckNorrisDao.insert(chuckNorrisQuote)
        }
}
