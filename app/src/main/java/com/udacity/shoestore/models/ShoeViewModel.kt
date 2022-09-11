package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {
    private val _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList: LiveData<List<Shoe>>
        get() = _shoesList

    fun addShoe(
        name: String, size: Double, company: String, description: String,
        images: List<String> = mutableListOf()
    ) {
        val item = Shoe(name, size, company, description)
        _shoesList.value = _shoesList.value?.plus(item) ?: listOf(item)
    }


    }

    /*init {
        val listOfShoe = mutableListOf<Shoe>()

        listOfShoe.addAll(
            listOf(
                Shoe("Кроссовки Moon Star", 40.toDouble(), "Nike", "Description"),
                Shoe("Кеды Paolo Richi", 38.toDouble(), "Mirrow", "Description")
            )
        )
        //_shoesList.value = listOfShoe
    }*/
