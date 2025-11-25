package com.example.tiptracker.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.example.tiptracker.data.TipDatabase
import com.example.tiptracker.data.TipRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TipRepository

    val tips = run {
        repository.tips.asLiveData()
    }

    init {
        val dao = TipDatabase.getDatabase(application).tipDao()
        repository = TipRepository(dao)
    }
}
