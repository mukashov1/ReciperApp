package com.example.reciper.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.*
import androidx.lifecycle.ViewModelProvider
import com.example.reciper.food.FoodAdapter
import com.example.reciper.R
import com.example.reciper.databinding.FragmentSearchBinding

class Search : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodAdapter: FoodAdapter

    private lateinit var binding: FragmentSearchBinding

    private val viewModel: SearchViewModel by lazy {
        ViewModelProvider(this).get(SearchViewModel::class.java)
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
        foodAdapter = FoodAdapter(viewModel.foodList)
        recyclerView.adapter = foodAdapter

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.btn.setOnClickListener {
            it.findNavController().navigate(com.example.reciper.search.SearchDirections.actionSearchToFoodMenu())
        }
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}