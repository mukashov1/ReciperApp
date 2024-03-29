package com.example.reciper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Saved : Fragment() {
    private  val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_saved, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.imagesRecyclerView)
        val manager = GridLayoutManager(activity, 3, GridLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = manager
        recyclerView.layoutManager = GridLayoutManager(this.requireContext(),3)

        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(requireContext(), viewModel)


    }

}
