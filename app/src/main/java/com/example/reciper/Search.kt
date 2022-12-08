package com.example.reciper

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.reciper.databinding.FragmentSearchBinding

class Search : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodAdapter: FoodAdapter

    private lateinit var binding: FragmentSearchBinding

    private val viewModel: SearchViewModel by lazy {
        ViewModelProvider(this)[SearchViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)

        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        var foodList = arrayListOf<Food>()
        binding.searchBtn.setOnClickListener {
            viewModel.getFoodProperties(binding.searchView.query.toString().lowercase())
            println("WWWW")
            Handler().postDelayed({
                foodList = viewModel.foodList
                println(foodList)
                foodAdapter = FoodAdapter(foodList)
                recyclerView.adapter = foodAdapter
            }, 3000)

            if (viewModel.response.value?.contains("Success") == true && foodList.size == 0) {
                Toast.makeText(
                    context,
                    "We can't find \"${binding.searchView.query}\" \nEnter another food!!!",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

        return binding.root
    }

}