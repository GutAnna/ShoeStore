package com.udacity.shoestore

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragInstructionsBinding

class InstructionsFragment : Fragment(R.layout.frag_instructions) {

    lateinit var binding: FragInstructionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragInstructionsBinding.bind(view)
        binding.btAccept.setOnClickListener {
            findNavController().navigate(R.id.action_instructionsFragment_to_welcomeFragment)
        }
    }
}