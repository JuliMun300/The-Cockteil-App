package com.example.thecockteilapp

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("search.php?s")
    suspend fun GetCockteilsAll(): Response<CockteilResponse>
}

private var GetRetrofit =
    Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


val service : ApiService = GetRetrofit.create(ApiService::class.java)