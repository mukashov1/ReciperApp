package com.example.reciper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val context: Context,
    private val viewModel: ProfileViewModel
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){


    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val img = itemView.findViewById<ImageView>(R.id.image)
        val imgTitle = itemView.findViewById<TextView>(R.id.image_title)
        fun bindView(image: Image) {
            img.setImageResource(image.imageSrc)
            imgTitle.text = image.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_images, parent, false))

    override fun getItemCount(): Int = viewModel.currentImages.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(viewModel.currentImages[position])
    }
}