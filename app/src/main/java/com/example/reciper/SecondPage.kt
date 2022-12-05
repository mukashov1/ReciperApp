package com.example.reciper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class SecondPage : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val b: Button = view.findViewById(R.id.button)
        b.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_second_page_to_log_in_page)
        }
        val b2: Button = view.findViewById(R.id.button2)
        b2.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_second_page_to_sign_up_page)
        }
    }
}