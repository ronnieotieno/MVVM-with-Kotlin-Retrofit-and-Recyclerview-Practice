package com.example.kotlinmvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvm.models.Post
import com.example.kotlinmvvm.models.WeatherList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {

    fun weather(lat: String, lon: String, cont: Int, api: String): LiveData<ArrayList<Post>> {

        val weather = MutableLiveData<ArrayList<Post>>()

        MyApi()
            .getWeather(lat, lon, cont, api).enqueue(object : Callback<WeatherList> {
                override fun onFailure(call: Call<WeatherList>, t: Throwable) {

                    Log.d("WeatherRepository", "Ronnie $t")

                }

                override fun onResponse(call: Call<WeatherList>, response: Response<WeatherList>) {
                    if (response.isSuccessful) {
                        weather.value = response.body()?.weather
                        Log.d("WeatherRepository", "Ronnie ${response.body()?.weather.toString()}")
                    } else {
                        Log.d("WeatherRepository", "Ronnie ${response.errorBody()}")
                    }
                }

            })

        return weather
    }

}