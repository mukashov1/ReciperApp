package com.example.reciper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FoodAdapter(private val foodList: ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(foodView: View) : RecyclerView.ViewHolder(foodView){

        val textView: TextView = foodView.findViewById(R.id.foodName)
        val imageView: ImageView = foodView.findViewById(R.id.foodImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent , false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.textView.text = food.foodName
        if (food.image != null) {

            food.image?.let {
                val imgUri =
                    food.image!!.toUri().buildUpon().scheme("https").build()
                Glide.with(holder.imageView.context)
                    .load(imgUri)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.loading_animation)
                    )
                    .into(holder.imageView)
            }
        }

        holder.itemView.setOnClickListener {
            it.findNavController().navigate(SearchDirections.actionSearchToFoodCard(food))
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}

