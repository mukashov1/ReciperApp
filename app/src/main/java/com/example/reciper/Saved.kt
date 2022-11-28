package com.example.reciper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Saved : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_saved, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val images = listOf<com.example.reciper.Image>(
            Image("Images 1", R.drawable.grilled_food_png_clipart_background),
            Image("Images 2",
                R.drawable.png_clipart_eatsa_fast_food_restaurant_hamburger_choripan_leaf_vegetable_food
            ),
            Image("Images 3",
                R.drawable.png_clipart_eatsa_fast_food_restaurant_hamburger_choripan_leaf_vegetable_food
            ),
            Image("Images 4",
                R.drawable.png_clipart_eatsa_fast_food_restaurant_hamburger_choripan_leaf_vegetable_food
            ),
            Image("Images 5", R.drawable.__2_junk_food_png_picture)
        )
        val recyclerView = view.findViewById<RecyclerView>(R.id.imagesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(requireContext(), images)


    }

}
