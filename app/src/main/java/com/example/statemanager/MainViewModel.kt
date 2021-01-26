package com.example.statemanager

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    enum class State {
        STATE_BLACK, STATE_RED, STATE_BLUE
    }

    fun requestInfo(state: State): String = when (state) {
        State.STATE_BLACK -> "#FF000000"
        State.STATE_RED -> "#FFFF0000"
        State.STATE_BLUE -> "#FF0000FF"
    }
}