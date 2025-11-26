package com.example.tiptracker.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiptracker.ui.home.HomeViewModel
import com.example.tiptracker.ui.home.HomeActivity
import androidx.lifecycle.observe
import com.example.tiptracker.databinding.ActivityHomeBinding
import com.example.tiptracker.ui.add.AddTipActivity
import com.example.tiptracker.ui.summary.DailySummaryActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val adapter = TipAdapter { tip ->
        viewModel.deleteTip(tip)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvTips.layoutManager = LinearLayoutManager(this)
        binding.rvTips.adapter = adapter

        viewModel.tips.observe(this) {
            adapter.submitList(it)
        }

        viewModel.todayTotal.observe(this) { total ->
            binding.tvTodayTotal.text = "Total today: %.2f лв".format(total)
        }

        binding.fabAddTip.setOnClickListener {
            startActivity(Intent(this, AddTipActivity::class.java))
        }

        binding.btnDailySummary.setOnClickListener {
            startActivity(Intent(this, DailySummaryActivity::class.java))
        }
    }
}
