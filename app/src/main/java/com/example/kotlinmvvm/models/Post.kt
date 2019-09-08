package com.example.kotlinmvvm.models

import com.example.kotlinmvvm.models.Main
import com.example.kotlinmvvm.models.WeatherMain
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class Post(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("main")
    @Expose
    val main: Main? = null,
    @SerializedName("weather")
    @Expose
    val weatherMains: ArrayList<WeatherMain>? = null
)


