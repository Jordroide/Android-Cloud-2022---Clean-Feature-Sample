package com.jordroid.android.cloud2021.chuckNorris.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jordroid.android.cloud2021.chuckNorris.data.model.ChuckNorrisRoom

@Dao
interface ChuckNorrisDao {

    @Query("SELECT * FROM chuck_norris_quote")
    fun selectAll(): LiveData<List<ChuckNorrisRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chuckNorrisRoom: ChuckNorrisRoom)

    @Query("DELETE FROM chuck_norris_quote")
    fun deleteAll()
}