package com.example.thecockteilapp

import android.os.Parcel
import android.os.Parcelable

data class Cockteil(
    val Id: String,
    val Nombre: String,
    val imagen: String?,
    val Ingrediente1:String?,
    val Ingrediente2:String?,
    val Ingrediente3:String?,
    val Instrucciones:String?
):java.io.Serializable