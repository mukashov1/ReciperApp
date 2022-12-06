package com.example.reciper

import android.os.Parcel
import android.os.Parcelable

data class Food(var foodName : String, var isFavorite: String = "false", var foodDescription: String = "The classic pile-up", var ingredientList: ArrayList<Ingredient>, var image: String? = null): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        arrayListOf<Ingredient>().apply {
            parcel.readList(this, Ingredient::class.java.classLoader)
        },
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(foodName)
        parcel.writeString(isFavorite)
        parcel.writeString(foodDescription)
        parcel.writeList(ingredientList)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Food> {
        override fun createFromParcel(parcel: Parcel): Food {
            return Food(parcel)
        }

        override fun newArray(size: Int): Array<Food?> {
            return arrayOfNulls(size)
        }
    }
}
