package com.jordroid.android.cloud2021.chuckNorris.data.mapper

import com.jordroid.android.cloud2021.chuckNorris.data.model.ChuckNorrisRetrofit
import com.jordroid.android.cloud2021.chuckNorris.data.model.ChuckNorrisRoom
import com.jordroid.android.cloud2021.chuckNorris.domain.model.ChuckNorrisDomain

fun ChuckNorrisRetrofit.toRoom(): ChuckNorrisRoom {
    return ChuckNorrisRoom(
        quote = quote,
        iconUrl = iconUrl
    )
}

fun List<ChuckNorrisRoom>.fromRoomToDomain(): List<ChuckNorrisDomain> {
    return map {
        ChuckNorrisDomain(
            quoteTitle = it.quote,
            imageUrl = it.iconUrl
        )
    }
}