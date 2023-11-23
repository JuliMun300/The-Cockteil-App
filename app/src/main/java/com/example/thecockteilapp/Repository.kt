package com.example.thecockteilapp

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {

    private val cockteilUseCase = CockteilUseCase()

    suspend fun GetCockteils():MutableList<Cockteil>{
        return withContext(Dispatchers.IO){

            var ListaCockteils = mutableListOf<Cockteil>()
            val call = service.GetCockteilsAll()

            if(call.isSuccessful){
                val response:CockteilResponse? = call.body()
                if(response?.drinks?.isNotEmpty()==true){
                    val drinks = response.drinks
                    ListaCockteils = cockteilUseCase.ParseallCockteils(drinks)
                }
            }else{
                Log.i("Error en la llamada", call.errorBody().toString())
            }

            ListaCockteils
        }


    }
}