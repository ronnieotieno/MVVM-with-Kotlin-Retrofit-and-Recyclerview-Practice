package com.example.kotlinmvvm

import androidx.lifecycle.LiveData
import com.example.kotlinmvvm.models.Post

interface ViewListener {
    fun onSuccess(message: String)
    fun onFailure(message: String)
    fun onApiStarted(weather: LiveData<ArrayList<Post>>)
}