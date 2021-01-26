package com.example.statemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.statemanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //NG : Activity 에서 상태를 관리
    //NG : 전역 변수로 상태를 관리
    var state = STATE_BLACK

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        init()
    }

    private fun init() {
        binding.button1.setOnClickListener {
            state = STATE_BLACK
            updateInfo(state)

        }
        binding.button2.setOnClickListener {
            state = STATE_RED
            updateInfo(state)
        }
        binding.button3.setOnClickListener {
            state = STATE_BLUE
            updateInfo(state)
        }
    }

    //NG : Activity가 상태를 분기해서 처리
    private fun updateInfo(state: Int) {
        when(state) {
            STATE_BLACK -> binding.image.setBackgroundColor(ContextCompat.getColor(baseContext ,R.color.black))
            STATE_RED -> binding.image.setBackgroundColor(ContextCompat.getColor(baseContext ,R.color.red))
            STATE_BLUE -> binding.image.setBackgroundColor(ContextCompat.getColor(baseContext ,R.color.blue))
            else -> throw IllegalStateException()
        }
        binding.image
    }

    companion object {
        //NG : 상수값으로 상태를 관리
        const val STATE_BLACK = 1
        const val STATE_RED = 2
        const val STATE_BLUE = 3
    }
}
