package com.example.thecockteilapp

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {

    private val cockteilUseCase = CocktailUseCase()

    suspend fun GetCockteils(query:String):MutableList<Cocktail>{
        return withContext(Dispatchers.IO){

            var ListaCockteils = mutableListOf<Cocktail>()
            val call = service.GetCockteilsAll("search.php?s=$query")

            if(call.isSuccessful){
                val response:CocktailResponse? = call.body()
                if(response?.drinks?.isNotEmpty()==true){
                    val drinks = response.drinks
                    ListaCockteils = cockteilUseCase.ParseAllCocktails(drinks)
                }
            }else{
                Log.i("Error en la llamada", call.errorBody().toString())
            }
            ListaCockteils
        }
    }
}