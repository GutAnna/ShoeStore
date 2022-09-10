package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentItemShoeBinding
import com.udacity.shoestore.models.ShoeViewModel


class ItemShoeFragment : Fragment() {
    lateinit var binding: FragmentItemShoeBinding
    private val sharedViewModel: ShoeViewModel by activityViewModels()
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_item_shoe, container, false)
        navController = findNavController()
        binding.btSave.setOnClickListener {
            with(binding) {
                sharedViewModel.addShoe(
                    editTextItemName.text.toString(),
                    editTextItemSize.text.toString().toDouble(),
                    editTextItemCompany.text.toString(),
                    editTextItemDescription.text.toString())
            }
            findNavController().navigateUp()
        }
        binding.btCancel.setOnClickListener {
            navController.navigateUp()
        }
        return binding.root
    }
}