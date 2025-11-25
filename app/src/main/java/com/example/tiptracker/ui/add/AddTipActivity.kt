package com.example.tiptracker.ui.add

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tiptracker.databinding.ActivityAddTipBinding
class AddTipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTipBinding
    private lateinit var viewModel: AddTipViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AddTipViewModel::class.java]

        binding.btnSave.setOnClickListener {
            val text = binding.etAmount.text.toString()

            if (text.isNotEmpty()) {
                viewModel.saveTip(text.toDouble())
                finish()
            }
        }
    }
}

