package com.example.reciper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reciper.databinding.FragmentFoodMenuBinding
import com.example.reciper.databinding.FragmentSearchBinding


class FoodMenu : Fragment() {

    private lateinit var recyclerView: RecyclerView
//    private lateinit var menuAdapter: MenuAdopter
    private lateinit var binding: FragmentFoodMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodMenuBinding.inflate(inflater,container,false)

//        recyclerView = binding.apiRecyclerView
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        recyclerView.setHasFixedSize(true)

//        menuAdapter = MenuAdopter()
//        recyclerView.adapter = menuAdapter

        return binding.root
    }

}