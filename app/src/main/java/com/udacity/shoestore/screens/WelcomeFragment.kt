package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragWelcomeBinding

class WelcomeFragment : Fragment(R.layout.frag_welcome) {
    lateinit var binding: FragWelcomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragWelcomeBinding.bind(view)
        binding.btGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_listProductsFragment)
        }
    }
}