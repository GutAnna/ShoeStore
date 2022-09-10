package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragListOfProductsBinding
import com.udacity.shoestore.models.ShoeViewModel

class ListProductsFragment : Fragment(R.layout.frag_list_of_products) {
    lateinit var binding: FragListOfProductsBinding
    private val  sharedViewModel: ShoeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragListOfProductsBinding.bind(view)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listProductsFragment_to_itemShoeFragment)
        }

        sharedViewModel.shoe.observe(viewLifecycleOwner, Observer { item ->
           val view = layoutInflater.inflate(R.layout.frag_list_of_products, null)

           binding.layoutContainer.addView(view)
        })

    }
}