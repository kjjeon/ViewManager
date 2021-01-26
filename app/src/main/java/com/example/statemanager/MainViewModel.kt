package com.example.statemanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.statemanager.data.ItemType
import com.example.statemanager.data.MainResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MainViewModel : ViewModel() {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    private val repository by lazy { MainRepository() }
    private val _stateLiveData = MutableLiveData<MainResult>()
    val stateLiveData: LiveData<MainResult>
        get() = _stateLiveData

    fun requestInfo(itemType: ItemType) {
        repository.query(itemType)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _stateLiveData.value = MainResult.InProgress }
            .subscribe({
                _stateLiveData.value = MainResult.Success(it)
            }, {
                _stateLiveData.value = MainResult.Error(it)
            })
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}