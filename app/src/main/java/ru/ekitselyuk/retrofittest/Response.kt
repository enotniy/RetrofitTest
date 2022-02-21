package ru.ekitselyuk.retrofittest

sealed class NetworkResult<T> {

    class Success<T>(val data: T) : NetworkResult<T>()

    class Error(val message: String?) : NetworkResult<Nothing>()

}

enum class Test(val value: Int) {
FIRTS(1),
Second(0)
}