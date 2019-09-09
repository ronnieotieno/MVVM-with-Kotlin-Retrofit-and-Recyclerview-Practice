package com.example.kotlinmvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmvvm.databinding.ActivityMainBinding
import com.example.kotlinmvvm.models.Post
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ViewListener {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.listener = this

        viewModel.fetchWeather()
    }

    override fun onSuccess(message: String) {
        toast(message)


    }

    override fun onFailure(message: String) {
        toast(message)
    }

    override fun onApiStarted(weather: LiveData<ArrayList<Post>>) {
        weather.observe(this, Observer {
            toast(it[6].name.toString())

            Log.d("MainActivity", "There ${it[9].weatherMains!![0].description.toString()}")
            recyclerview.layoutManager = LinearLayoutManager(this)
            val adapter = RecyclerViewAdapter(this, it)
            recyclerview.adapter = adapter
        })
    }
}
