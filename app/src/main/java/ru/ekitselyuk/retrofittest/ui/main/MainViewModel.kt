package ru.ekitselyuk.retrofittest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(), MainViewModelType {

    private val repository = Repository()
    private val defaultValue = 0

    private val _counter = MutableLiveData<MainUIState>(MainUIState.Loading())
    val state: LiveData<MainUIState> = _counter

    fun clickButton() {
        viewModelScope.launch {
            _counter.value = repository.getNewData(counter.value ?: defaultValue)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}

sealed class MainUIState {

    class Loading: MainUIState()
    class Error: MainUIState()
    class Success(val data: String): MainUIState()

}