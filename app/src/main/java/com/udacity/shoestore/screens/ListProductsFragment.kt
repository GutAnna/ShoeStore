package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragListOfProductsBinding
import com.udacity.shoestore.databinding.ItemProductBinding
import com.udacity.shoestore.models.ShoeViewModel

class ListProductsFragment : Fragment(R.layout.frag_list_of_products) {
    lateinit var binding: FragListOfProductsBinding
    private val  sharedViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.frag_list_of_products,container,false)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listProductsFragment_to_itemShoeFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.shoe.observe(viewLifecycleOwner, Observer { item ->
            val linearLayout = binding.layoutContainer
            val itemProductBinding = DataBindingUtil.inflate<ItemProductBinding>(
                layoutInflater,
                R.layout.item_product,
                linearLayout,
                true
            )
            itemProductBinding.shoe = item
        })
    }

}