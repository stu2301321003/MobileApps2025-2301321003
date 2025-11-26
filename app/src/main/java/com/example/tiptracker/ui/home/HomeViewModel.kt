package com.example.tiptracker.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.map
import com.example.tiptracker.data.Tip
import com.example.tiptracker.data.TipDatabase
import com.example.tiptracker.data.TipRepository
import kotlinx.coroutines.launch
import java.util.Calendar

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TipRepository =
        TipRepository(TipDatabase.getDatabase(application).tipDao())

    val tips = repository.tips.asLiveData()

    val todayTotal = tips.map { list: List<Tip> ->
        val startOfDay = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        list.filter { it.timestamp >= startOfDay }
            .sumOf { it.amount }
    }

    fun deleteTip(tip: Tip) {
        viewModelScope.launch {
            repository.deleteTip(tip)
        }
    }
}
