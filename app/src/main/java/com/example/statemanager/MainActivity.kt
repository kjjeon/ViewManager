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
        initObserve()
    }

    private fun init() {
        binding.button1.setOnClickListener {
            viewModel.requestInfo(MainViewModel.State.STATE_BLACK)
        }
        binding.button2.setOnClickListener {
            viewModel.requestInfo(MainViewModel.State.STATE_RED)
        }
        binding.button3.setOnClickListener {
            viewModel.requestInfo(MainViewModel.State.STATE_BLUE)
        }
    }

    private  fun initObserve() {
        viewModel.stateLiveData
            .observe(this, { binding.image.setBackgroundColor(Color.parseColor(it)) })
    }
}
