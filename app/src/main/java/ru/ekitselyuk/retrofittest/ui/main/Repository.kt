package ru.ekitselyuk.retrofittest.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Repository {

    suspend fun getNewData(current: Int): Int {
        return withContext(Dispatchers.IO) {
            delay(2000)
            return@withContext current + 1
        }
    }
}