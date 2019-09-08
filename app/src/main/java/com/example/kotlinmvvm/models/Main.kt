package com.example.kotlinmvvm.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Main(
    @SerializedName("temp")
    @Expose
    var temp: String? = null,
    @SerializedName("pressure")
    @Expose
    var pressure: String? = null
)
