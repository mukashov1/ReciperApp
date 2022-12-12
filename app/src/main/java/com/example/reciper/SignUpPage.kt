package com.example.reciper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation

class SignUpPage : Fragment() {
    private  val viewModel: ViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up_page, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val b: Button = view.findViewById(R.id.button4)
        b.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_sign_up_page_to_log_in_page)
        }

    }
}