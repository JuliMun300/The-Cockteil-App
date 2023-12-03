package com.example.thecockteilapp

data class CocktailResponse(val drinks: MutableList<Drinks>)

data class Drinks(
    val idDrink: String,
    val strDrink: String,
    val strDrinkThumb:String,
    val strIngredient1:String?,
    val strIngredient2:String?,
    val strIngredient3:String?,
    val strInstructions:String?
)