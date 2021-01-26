package com.example.statemanager

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.statemanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        init()
    }

    private fun init() {
        binding.button1.setOnClickListener {
            binding.image.setBackgroundColor(
                Color.parseColor(
                    (viewModel.requestInfo(MainViewModel.STATE_BLACK))
                )
            )
        }
        binding.button2.setOnClickListener {
            binding.image.setBackgroundColor(
                Color.parseColor(
                    (viewModel.requestInfo(MainViewModel.STATE_RED))
                )
            )
            viewModel.requestInfo(MainViewModel.STATE_RED)
        }
        binding.button3.setOnClickListener {
            binding.image.setBackgroundColor(
                Color.parseColor(
                    (viewModel.requestInfo(MainViewModel.STATE_BLUE))
                )
            )
            viewModel.requestInfo(MainViewModel.STATE_BLUE)
        }
    }
}
