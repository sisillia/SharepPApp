package com.example.sharedpapp.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sharedpapp.ImageDetailActivity
import com.example.sharedpapp.LoginActivity
import com.example.sharedpapp.model.ImageModel
import com.example.sharedpapp.R
import kotlinx.android.synthetic.main.recycler_view_image.view.*



class ImageAdapter(private val listImage: ArrayList<ImageModel>): RecyclerView.Adapter<ImageAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_view_image, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listImage.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listImage[position])
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(listImage: ImageModel){
            with(itemView){
                Glide.with(itemView.context)
                    .load(listImage.photo)
                    .into(rv_image)

                itemView.setOnClickListener {
                    val intent = Intent(context.applicationContext, ImageDetailActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_MULTIPLE_TASK
                    intent.putExtra(ImageSlidingAdapter.EXTRA_POSITION,adapterPosition)
                    context.applicationContext.startActivity(intent)
                }
            }
        }
    }
}