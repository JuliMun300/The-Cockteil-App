package com.example.thecockteilapp

class CocktailUseCase {

    fun ParseAllCocktails(drinks: MutableList<Drinks>): MutableList<Cocktail>{
        val listaCockteils = mutableListOf<Cocktail>()

        for(drink in drinks){
            val id = drink.idDrink
            val nombre = drink.strDrink
            val imagen = drink.strDrinkThumb
            val ingrediente1 = drink.strIngredient1
            val ingrediente2 = drink.strIngredient2
            val ingrediente3 = drink.strIngredient3
            val instrucciones = drink.strInstructions

            val cockteil = Cocktail(id,nombre,imagen,ingrediente1,ingrediente2,ingrediente3,instrucciones)
            listaCockteils.add(cockteil)
        }
        return listaCockteils
    }
}