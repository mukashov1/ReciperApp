package com.example.reciper.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reciper.R
import com.example.reciper.databinding.FragmentFoodCardBinding
import com.example.reciper.search.SearchViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FoodCard : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var ingredientAdopter: IngredientAdopter
    private lateinit var binding: FragmentFoodCardBinding

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_card, container, false)

        val args = com.example.reciper.FoodCardArgs.fromBundle(requireArguments())
        val food = args.food
        val isFavorite: TextView = binding.addToFavBtn
        val foodDescription: TextView = binding.descriptionText

//        binding.foodCardName.text = food.foodName
//        if (food.isFavorite == "false") {
//            isFavorite.isClickable = false
//        }
//        isFavorite.setOnClickListener {
//            if (isFavorite.text == "Favorite") {
//                isFavorite.text = "Add to Fav"
//                viewModel.removeFromFav(food)
//
//            } else {
//                isFavorite.text = "Favorite"
//                viewModel.addToFav(food)
//            }
//
//        }
//        foodDescription.text = args.food.foodDescription

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


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FoodCard.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FoodCard().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}