package com.example.tiptracker.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tiptracker.databinding.ActivityHomeBinding
import com.example.tiptracker.ui.add.AddTipActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val adapter = TipAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvTips.layoutManager = LinearLayoutManager(this)
        binding.rvTips.adapter = adapter

        viewModel.tips.observe(this) {
            adapter.submitList(it)
        }

        binding.fabAddTip.setOnClickListener {
            startActivity(Intent(this, AddTipActivity::class.java))
        }
    }
}
