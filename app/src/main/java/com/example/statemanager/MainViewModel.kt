package com.example.statemanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _stateLiveData = MutableLiveData<String>()
    val stateLiveData: LiveData<String>
        get() = _stateLiveData

    enum class State(val title: String, val colorId: String) {
        STATE_BLACK("black","#FF000000"),
        STATE_RED("red","#FFFF0000"),
        STATE_BLUE("blue", "#FF0000FF")
    }

    fun requestInfo(state: State) {
        _stateLiveData.value = state.colorId
    }
}