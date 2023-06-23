package com.maloac.pokedex.network

import com.maloac.pokedex.components.models.PokedexData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DataService {
    @GET("pokemon")
    fun getPokemonByName(@Query("name")name: String): Call<PokedexData>


    @GET("pokemon")
    fun getAllPokemon(): Call<PokedexData>
}