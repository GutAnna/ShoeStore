package com.udacity.shoestore

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragLoginBinding

class LoginFragment : Fragment(R.layout.frag_login) {
    lateinit var binding: FragLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragLoginBinding.bind(view)
        binding.btLogin.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment_to_instructionsFragment
            )
        }
        binding.tvRegistration.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment_to_instructionsFragment
            )
        }
    }
}