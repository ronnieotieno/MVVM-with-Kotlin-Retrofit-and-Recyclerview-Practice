package com.example.kotlinmvvm.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class WeatherList(
    @SerializedName("list")
    @Expose
    var weather: ArrayList<Post>? = null
)