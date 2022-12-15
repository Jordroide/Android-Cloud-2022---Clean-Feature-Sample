package com.jordroid.android.cloud2021.chuckNorris.view.mapper

import com.jordroid.android.cloud2021.chuckNorris.domain.model.ChuckNorrisDomain
import com.jordroid.android.cloud2021.chuckNorris.view.model.ChuckNorrisUi

fun List<ChuckNorrisDomain>.fromDomainToUi(): List<ChuckNorrisUi> {
    return map {
        ChuckNorrisUi(
            title = it.quoteTitle,
            url = it.imageUrl
        )
    }
}