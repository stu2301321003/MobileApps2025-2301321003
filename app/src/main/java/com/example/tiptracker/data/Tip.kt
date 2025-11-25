package com.example.tiptracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tips")
data class Tip(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val amount: Double,
    val timestamp: Long = System.currentTimeMillis()
)
