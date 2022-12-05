package com.example.reciper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foodList: ArrayList<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(foodView: View) : RecyclerView.ViewHolder(foodView){

        val textView: TextView = foodView.findViewById(R.id.foodName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent , false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.textView.text = food.foodName

        holder.itemView.setOnClickListener {
            it.findNavController().navigate(com.example.reciper.SearchDirections.actionSearchToFoodCard(food))
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}

