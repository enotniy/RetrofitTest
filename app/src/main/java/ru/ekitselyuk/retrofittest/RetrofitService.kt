package ru.ekitselyuk.retrofittest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface RetrofitService {

    @GET("users/{username}")
    fun getUser(@Path("username") username: String?): Call<NetworkResult<User>>?
}

data class User(val name: String) {

}