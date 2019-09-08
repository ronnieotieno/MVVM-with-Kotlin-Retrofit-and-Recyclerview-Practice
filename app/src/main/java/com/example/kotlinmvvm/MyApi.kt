package com.example.kotlinmvvm

import com.example.kotlinmvvm.models.WeatherList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {
    @GET("data/2.5/find")
    fun getWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("cnt") count: Int,
        @Query("appid") api: String
    ): Call<WeatherList>

    companion object {
        operator fun invoke(
            // networkConnectionInterceptor: NetworkConnectionInterceptor
        ): MyApi {

            return Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}