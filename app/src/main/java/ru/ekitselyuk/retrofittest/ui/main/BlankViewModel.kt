package ru.ekitselyuk.retrofittest.ui.main

import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    override fun onCleared() {
        saveToRepository()
        super.onCleared()
    }
}