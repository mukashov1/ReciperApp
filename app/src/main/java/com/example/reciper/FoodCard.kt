package com.example.reciper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.reciper.databinding.FragmentFoodCardBinding

class FoodCard : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var ingredientAdopter: IngredientAdopter
    private lateinit var binding: FragmentFoodCardBinding

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_card, container, false)

        val args = FoodCardArgs.fromBundle(requireArguments())
        val food = args.food
        val image = args.food.image
        val isFavorite: TextView = binding.addToFavBtn
        val foodDescription: TextView = binding.descriptionText
        if (image != null) {

            image?.let {
                val imgUri =
                    image.toUri().buildUpon().scheme("https").build()
                Glide.with(binding.foodImage.context)
                    .load(imgUri)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.loading_animation)
                    )
                    .into(binding.foodImage)
            }
        }

        binding.foodCardName.text = food.foodName
//        if (food.isFavorite == "false") {
//        }
//            isFavorite.isClickable = true
        isFavorite.setOnClickListener {
            if (isFavorite.text == "Favorite") {
                isFavorite.text = "Add to Fav"
                viewModel.removeFromFav(food)

            } else {
                isFavorite.text = "Favorite"
                viewModel.addToFav(food)
            }

        }
        foodDescription.text = args.food.foodDescription

        recyclerView = binding.ingredientRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        ingredientAdopter = IngredientAdopter(args.food.ingredientList)
        recyclerView.adapter = ingredientAdopter

        val foodBack: TextView = binding.foodBack
        foodBack.setOnClickListener { view: View ->
            if (binding.foodCardName.text == "Beshbarmak")
                view.findNavController().navigate(R.id.action_foodCard_to_home)
            else
                view.findNavController().navigate(R.id.action_foodCard_to_search)
        }
        return binding.root
    }
}