package com.example.reciper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [goodFood.newInstance] factory method to
 * create an instance of this fragment.
 */
class goodFood : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_good_food, container, false)

        val ingredientList = arrayListOf(
            Ingredient("2 - stick unsalted butter") ,
            Ingredient("3 - English muffins, opened"),
            Ingredient("6 - Eggs, plus 3 egg yolks, divided"),
            Ingredient("2 - Tablespoons lemon juice"),
            Ingredient("3 - English muffins, opened"),
            Ingredient("3 - English muffins, opened"),
            Ingredient("3 - English muffins, opened"),)

        val cardView1 = root.findViewById<CardView>(R.id.card_vegan1)
        val cardView2 = root.findViewById<CardView>(R.id.card_vegan2)

        val linear: LinearLayout = root.findViewById(R.id.linearLayout)
        linear.setOnClickListener{
            it.findNavController().navigate(goodFoodDirections.actionHomeToFoodCard(Food(foodName = "Beshbarmak" , ingredientList = ingredientList)))
        }

        cardView1.setOnClickListener{
            it.findNavController().navigate(goodFoodDirections.actionHomeToFoodCard(Food(foodName = "Beshbarmak" , ingredientList = ingredientList)))
        }

        cardView2.setOnClickListener{
            it.findNavController().navigate(goodFoodDirections.actionHomeToFoodCard(Food(foodName = "Beshbarmak" , ingredientList = ingredientList)))
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
         * @return A new instance of fragment goodFood.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            goodFood().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}