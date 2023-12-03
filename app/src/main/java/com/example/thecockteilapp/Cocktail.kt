package com.example.thecockteilapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cocktail(
    val Id: String,
    val Nombre: String,
    val imagen: String?,
    val Ingrediente1:String?,
    val Ingrediente2:String?,
    val Ingrediente3:String?,
    val Instrucciones:String?
):Parcelable