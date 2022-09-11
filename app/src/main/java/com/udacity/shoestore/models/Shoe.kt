package com.udacity.shoestore.models

import androidx.databinding.ObservableField

//import kotlinx.android.parcel.Parcelize

//@Parcelize
data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String,
    val images: List<String> = mutableListOf()
) {
    //: Parcelable
    var dataBindingSize = ObservableField<String>(size.toString())
}
