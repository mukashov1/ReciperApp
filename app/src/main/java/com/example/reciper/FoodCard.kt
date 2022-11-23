package com.example.reciper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FoodCard.newInstance] factory method to
 * create an instance of this fragment.
 */
class FoodCard : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var ingredientAdopter: IngredientAdopter

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
        val root  = inflater.inflate(R.layout.fragment_food_card, container, false)


        val args = FoodCardArgs.fromBundle(requireArguments())
        val foodName: TextView = root.findViewById(R.id.foodCardName)
        val isFavorite: TextView = root.findViewById(R.id.addToFavBtn)
        val foodDescription: TextView = root.findViewById(R.id.descriptionText)

        foodName.text = args.food.foodName
        if (args.food.isFavorite == "false") {
            isFavorite.isClickable = false
        }
        isFavorite.setOnClickListener {
//            viewModel.addToFav(args.food)
            isFavorite.text = "Favorite"
            Toast.makeText(context, "This food already favorite!!!" , Toast.LENGTH_LONG).show()
        }
        foodDescription.text = args.food.foodDescription

        recyclerView = root.findViewById(R.id.ingredientRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        ingredientAdopter = IngredientAdopter(args.food.ingredientList)
        recyclerView.adapter = ingredientAdopter

        val foodBack: TextView = root.findViewById(R.id.foodBack)
        foodBack.setOnClickListener { view : View ->
            if(foodName.text == "Beshbarmak")
                view.findNavController().navigate(R.id.action_foodCard_to_home)
            else
                view.findNavController().navigate(R.id.action_foodCard_to_search)
        }
        return root
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