package com.example.reciper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reciper.databinding.FragmentSearchBinding
import kotlinx.coroutines.NonDisposableHandle.parent


class FoodMenu : Fragment() {

    private lateinit var recyclerView: RecyclerView
//    private lateinit var menuAdapter: MenuAdopter
//    private lateinit var binding: FragmentFoodMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_food_menu, container, false)
//        binding = FragmentFoodMenuBinding.inflate(inflater,container,false)

//        recyclerView = binding.apiRecyclerView
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        recyclerView.setHasFixedSize(true)

//        menuAdapter = MenuAdopter()
//        recyclerView.adapter = menuAdapter

        return root
    }

}