package com.example.tiptracker.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiptracker.data.TipDatabase
import com.example.tiptracker.data.TipRepository
import kotlinx.coroutines.launch

class AddTipViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TipRepository

    init {
        val dao = TipDatabase.Companion.getDatabase(application).tipDao()
        repository = TipRepository(dao)
    }

    fun saveTip(amount: Double) {
        viewModelScope.launch {
            repository.addTip(amount)
        }
    }
}