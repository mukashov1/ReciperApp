package com.example.reciper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IngredientAdopter(private  val ingredientList: ArrayList<Ingredient>): RecyclerView.Adapter<IngredientAdopter.IngredientViewHolder>() {

    class IngredientViewHolder(ingredientView: View): RecyclerView.ViewHolder(ingredientView) {

        val textView: TextView = ingredientView.findViewById(R.id.txt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_ingredient, parent , false)
        return IngredientViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val ingredient = ingredientList[position]
        holder.textView.text = ingredient.ingredient
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

}