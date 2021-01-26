package com.example.statemanager

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.statemanager.data.ItemType
import com.example.statemanager.data.MainResult
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
            viewModel.requestInfo(ItemType.BLACK)
        }
        binding.button2.setOnClickListener {
            viewModel.requestInfo(ItemType.RED)
        }
        binding.button3.setOnClickListener {
            viewModel.requestInfo(ItemType.BLUE)
        }
    }

    private  fun initObserve() {
        viewModel.stateLiveData
            .observe(this, {
                when (it) {
                    is MainResult.Success -> {
                        binding.image.setBackgroundColor(Color.parseColor(it.data.color))
                    }
                    is MainResult.Error -> {
                        println("Error: ${it.exception}")
                    }
                    is MainResult.InProgress -> {
                        println("In progress")
                    }
                }
            })
    }
}
