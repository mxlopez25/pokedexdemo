package com.maloac.pokedex.network

import retrofit2.Retrofit

object Api {
    private val BASE_URL = "https://pokeapi.co/api/v2/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: DataService by lazy {
        retrofit.create(DataService::class.java)
    }
}