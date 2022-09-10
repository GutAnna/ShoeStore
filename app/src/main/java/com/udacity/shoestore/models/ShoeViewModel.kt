package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe> = _shoe


    fun addShoe(
        name: String, size: Double, company: String, description: String,
        images: List<String> = mutableListOf()
    ) {
        val item = Shoe(name, size, company, description)
        _shoe.value = item
        //_shoesList.value = _shoesList.value?.plus(item) ?: listOf(item)
    }

   /* init {
        val listOfShoe = mutableListOf<Shoe>()

        listOfShoe.addAll(
            listOf(
                Shoe("Кроссовки Moon Star", 40.toDouble(), "Nike", "Description"),
                Shoe("Кеды Paolo Richi", 40.toDouble(), "Mirrow", "Description")
            )
        )
        //_shoesList.value = listOfShoe
    }*/
}