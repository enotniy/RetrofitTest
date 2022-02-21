package ru.ekitselyuk.retrofittest

import android.app.Application
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type


class App: Application() {

    companion object {
        private var _retrofit: Retrofit? = null
        val retrofit = _retrofit!!

        private var _retrofitService: RetrofitService? = null
        val retrofitService = _retrofitService!!
    }

    override fun onCreate() {
        super.onCreate()

        _retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory())
            .addConverterFactory(GsonConverterFactory())
            .build()

        _retrofitService = retrofit.create(RetrofitService::class.java)
    }
}