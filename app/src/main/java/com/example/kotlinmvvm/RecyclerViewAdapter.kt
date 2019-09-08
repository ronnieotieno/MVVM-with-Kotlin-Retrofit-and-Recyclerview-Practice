package com.example.kotlinmvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.databinding.ActivityAdapterBinding
import com.example.kotlinmvvm.models.Post
import com.example.kotlinmvvm.models.PostDisplay

class RecyclerViewAdapter(var context: Context, var posts: List<Post>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val activityAdapterBinding = DataBindingUtil.inflate<ActivityAdapterBinding>(
            LayoutInflater
                .from(parent.context), R.layout.activity_adapter, parent, false
        )
        return MyViewHolder(activityAdapterBinding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = posts[position]
        holder.setData(post)

    }

    inner class MyViewHolder(var activityAdapterBinding: ActivityAdapterBinding) :
        RecyclerView.ViewHolder(activityAdapterBinding.root) {

        fun setData(post: Post) {
            post.let {
                val city = it.name
                val temp = it.main?.temp
                val id = it.id
                val desc = it.weatherMains!![0].description

                val postDisplay = PostDisplay(city, temp, id, desc)

                activityAdapterBinding.postDisplay = postDisplay

            }

        }
    }

}