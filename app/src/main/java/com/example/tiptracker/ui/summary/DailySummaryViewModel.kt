package com.example.tiptracker.ui.summary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.example.tiptracker.data.Tip
import com.example.tiptracker.data.TipDatabase
import com.example.tiptracker.data.TipRepository
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.coroutines.flow.map

data class DailySummary(val day: String, val total: Double)

class DailySummaryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TipRepository(
        TipDatabase.getDatabase(application).tipDao()
    )

    val dailySummary = repository.tips.map { tips: List<Tip> ->

        val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())

        tips.groupBy { tip ->
            formatter.format(Date(tip.timestamp))
        }.map { (day, items) ->
            DailySummary(day, items.sumOf { it.amount })
        }.sortedByDescending { it.day }

    }.asLiveData()
}
