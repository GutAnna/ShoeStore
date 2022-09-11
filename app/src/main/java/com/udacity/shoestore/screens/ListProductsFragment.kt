package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
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
        sharedViewModel.shoesList.observe(viewLifecycleOwner) { list ->
            val linearLayout = binding.layoutContainer
            for (item in list) {
                val itemProductBinding = DataBindingUtil.inflate<ItemProductBinding>(
                    layoutInflater,
                    R.layout.item_product,
                    linearLayout,
                    true
                )
                itemProductBinding.shoe = item
                //linearLayout.addView(itemProductBinding.root)
            }
        }
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return when (menuItem.itemId) {
                    R.id.logout -> {
                        findNavController().navigate(R.id.loginFragment)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

}