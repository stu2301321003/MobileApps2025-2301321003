package com.example.tiptracker.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptracker.databinding.ActivityHomeBinding
import com.example.tiptracker.ui.add.AddTipActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAddTip.setOnClickListener {
            startActivity(Intent(this, AddTipActivity::class.java))
        }
    }
}
