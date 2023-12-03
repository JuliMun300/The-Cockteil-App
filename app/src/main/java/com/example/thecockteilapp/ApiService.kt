package com.example.thecockteilapp

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun GetCockteilsAll(@Url url:String): Response<CocktailResponse>
}

private var GetRetrofit =
    Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


val service : ApiService = GetRetrofit.create(ApiService::class.java)