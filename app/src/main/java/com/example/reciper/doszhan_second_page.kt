package com.example.reciper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class doszhan_second_page : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doszhan_second_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val b: Button = view.findViewById(R.id.button)
        b.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_doszhan_second_page_to_doszhan_log_in_page)
        }
        val b2: Button = view.findViewById(R.id.button2)
        b2.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_doszhan_second_page_to_doszhan_sign_up_page)
        }
    }
}