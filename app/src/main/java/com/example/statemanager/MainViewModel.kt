package com.example.statemanager

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    enum class State(val title: String, val colorId: String) {
        STATE_BLACK("black","#FF000000"),
        STATE_RED("red","#FFFF0000"),
        STATE_BLUE("blue", "#FF0000FF")
    }

    fun requestInfo(state: State): String = state.colorId
}