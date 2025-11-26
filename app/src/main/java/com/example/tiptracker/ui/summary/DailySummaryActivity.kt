package com.example.tiptracker.ui.summary

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiptracker.databinding.ActivityDailySummaryBinding
import androidx.lifecycle.observe

class DailySummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDailySummaryBinding
    private val viewModel: DailySummaryViewModel by viewModels()
    private val adapter = DailySummaryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDailySummary.layoutManager = LinearLayoutManager(this)
        binding.rvDailySummary.adapter = adapter

        viewModel.dailySummary.observe(this) { list: List<DailySummary> ->
            adapter.submitList(list)
        }
    }
}
