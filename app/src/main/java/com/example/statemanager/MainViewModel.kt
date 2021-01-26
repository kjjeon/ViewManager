package com.example.statemanager

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        const val STATE_BLACK = 1
        const val STATE_RED = 2
        const val STATE_BLUE = 3
    }


    fun requestInfo(state: Int): String = when (state) {
            STATE_BLACK -> "#FF000000"
            STATE_RED -> "#FFFF0000"
            STATE_BLUE -> "#FF0000FF"
            else -> throw IllegalStateException()
    }
}