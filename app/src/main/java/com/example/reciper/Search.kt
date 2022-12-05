package com.example.reciper

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.*
import androidx.lifecycle.ViewModelProvider
import com.example.reciper.databinding.FragmentSearchBinding

class Search : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodAdapter: FoodAdapter

    private lateinit var binding: FragmentSearchBinding

    private val viewModel: SearchViewModel by lazy {
        ViewModelProvider(this)[SearchViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        var foodList = arrayListOf<Food>()
        Handler().postDelayed({
            println("WWWW")
            foodList = viewModel.foodList
            println(foodList)
            foodAdapter = FoodAdapter(foodList)
            recyclerView.adapter = foodAdapter
        }, 3000)



        return binding.root;
    }

}