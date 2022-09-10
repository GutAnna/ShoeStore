package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragWelcomeBinding

class WelcomeFragment : Fragment(R.layout.frag_welcome) {
    lateinit var binding: FragWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.frag_welcome,
            container,
            false
        )
        binding.btGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_listProductsFragment)
        }
        return binding.root
    }
}