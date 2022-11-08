package com.example.reciper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition


class RecyclerAdapter/*(private val dataSet: Array<String>)*/ :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var images = intArrayOf(R.drawable.kazakh_dish,R.drawable.italian_dish,R.drawable.korean_dish)

    private var texts = arrayOf("Kazakh Dishes" , "Italian Dishes" , "Korean Dishes")



inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemImage: ImageView
    val itemText: TextView


    init {
        // Define click listener for the ViewHolder's View.
        itemImage = view.findViewById(R.id.ima_dish)
        itemText = view.findViewById(R.id.text_dish)
    }
}

// Create new views (invoked by the layout manager)
override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
    // Create a new view, which defines the UI of the list item
    val view = LayoutInflater.from(viewGroup.context)
        .inflate(R.layout.card_layout1, viewGroup, false)

    return ViewHolder(view)
}

// Replace the contents of a view (invoked by the layout manager)
override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

    // Get element from your dataset at this position and replace the
    // contents of the view with that element
    viewHolder.itemImage.setImageResource(images[position]) //=dataSet[position]
    viewHolder.itemText.text = texts[position] //=dataSet[position]
}

// Return the size of your dataset (invoked by the layout manager)
override fun getItemCount(): Int { //= dataSet.size
    return texts.size
}

}