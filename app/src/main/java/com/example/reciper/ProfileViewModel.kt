package com.example.reciper

import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel(){




    private val images = listOf<com.example.reciper.Image>(
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
        Image("Images 5", R.drawable.__2_junk_food_png_picture),
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
        Image("Images 5", R.drawable.__2_junk_food_png_picture),
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
        Image("Images 5", R.drawable.__2_junk_food_png_picture),
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

    val currentImages:List<com.example.reciper.Image>
        get() = images
}