package com.example.kotlinmvvm

import android.view.View
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    var toast: String? = null
    var listener: ViewListener? = null

    fun btnClicked(view: View) {
        if (toast.isNullOrEmpty()) {
            listener?.onFailure("Enter Something")
            return
        } else {
            listener?.onSuccess(toast!!)
        }
    }

    fun yes() {
        val weather = WeatherRepository().weather(
            "37.0902",
            "-95.7129",
            50,
            "efbcfd06753e965bb0bc8f0850aa6c7c"
        )
        listener?.onApiStarted(weather)
    }

}