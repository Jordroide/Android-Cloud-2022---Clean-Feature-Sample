package com.jordroid.android.cloud2021.chuckNorris.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.jordroid.android.cloud2021.chuckNorris.domain.usecase.DeleteAllChuckNorrisUseCase
import com.jordroid.android.cloud2021.chuckNorris.domain.usecase.FetchNewDataChuckNorrisUseCase
import com.jordroid.android.cloud2021.chuckNorris.domain.usecase.GetChuckNorrisUseCase
import com.jordroid.android.cloud2021.chuckNorris.view.mapper.fromDomainToUi
import com.jordroid.android.cloud2021.chuckNorris.view.model.ChuckNorrisUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChuckNorrisViewModel : ViewModel() {

    private val getChuckNorrisUseCase: GetChuckNorrisUseCase by lazy { GetChuckNorrisUseCase() }
    private val fetchNewDataChuckNorrisUseCase: FetchNewDataChuckNorrisUseCase by lazy { FetchNewDataChuckNorrisUseCase() }
    private val deleteAllChuckNorrisUseCase: DeleteAllChuckNorrisUseCase by lazy { DeleteAllChuckNorrisUseCase() }

    var chuckNorrisQuoteLiveData: LiveData<List<ChuckNorrisUi>> =
        getChuckNorrisUseCase.selectAll().map {
            it.fromDomainToUi()
        }

    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchNewDataChuckNorrisUseCase.fetchData()
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllChuckNorrisUseCase.deleteAll()
        }
    }
}

