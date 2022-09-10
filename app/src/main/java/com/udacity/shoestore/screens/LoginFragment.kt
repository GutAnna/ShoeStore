package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragLoginBinding

class LoginFragment : Fragment(R.layout.frag_login) {
    lateinit var binding: FragLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_login, container,false)
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
        return binding.root
    }


}