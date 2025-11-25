package com.example.tiptracker.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TipDao {

    @Insert
    suspend fun insertTip(tip: Tip)

    @Query("SELECT * FROM tips ORDER BY timestamp DESC")
    fun getAllTips(): Flow<List<Tip>>
}
