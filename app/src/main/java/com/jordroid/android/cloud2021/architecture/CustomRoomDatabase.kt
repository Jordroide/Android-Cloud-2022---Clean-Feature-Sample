package com.jordroid.android.cloud2021.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jordroid.android.cloud2021.chuckNorris.data.local.ChuckNorrisDao
import com.jordroid.android.cloud2021.chuckNorris.data.model.ChuckNorrisRoom

// Here goes the configuration of all entities needed
@Database(
    entities = [
        ChuckNorrisRoom::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    // Here goes the list of all DAO needed
    abstract fun chuckNorrisDao(): ChuckNorrisDao
}
