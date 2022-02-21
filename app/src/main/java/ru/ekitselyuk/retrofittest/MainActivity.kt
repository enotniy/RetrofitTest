package ru.ekitselyuk.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.coroutines.newFixedThreadPoolContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.ekitselyuk.retrofittest.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        val callback: () -> String = {
            if (true) {
                "Test"
            } else {
                "Test2"
            }
        }

        val callback = object: Callback<NetworkResult<User>> {
            override fun onResponse(
                call: Call<NetworkResult<User>>,
                response: Response<NetworkResult<User>>
            ) {
                when {
                    response.code() == 200 -> {
                        Gson.parse<User>(response.body())
                        NetworkResult.Success<User>(User("test"))
                    }
                    response.code() == 404 -> {
                        NetworkResult.Error("404")
                    }
                    else -> {
                        TODO()
                    }
                }
            }

            override fun onFailure(call: Call<NetworkResult<User>>, t: Throwable) {
                NetworkResult.Error("unknown error")
            }

        }
        App.retrofitService.getUser("test")?.enqueue(callback)

        finish()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}