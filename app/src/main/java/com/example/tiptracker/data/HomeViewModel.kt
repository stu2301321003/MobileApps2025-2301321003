package com.example.tiptracker.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.example.tiptracker.data.TipDatabase
import com.example.tiptracker.data.TipRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TipRepository =
        TipRepository(TipDatabase.getDatabase(application).tipDao())

    val tips = repository.tips.asLiveData()
}
