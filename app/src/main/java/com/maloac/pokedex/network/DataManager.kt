package com.maloac.pokedex.network

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.maloac.pokedex.components.models.PokedexData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataManager {
    private val _dataResponse = mutableStateOf(PokedexData())
    val dataResponse: State<PokedexData>
        @Composable get() = remember {
            _dataResponse
        }

    init {
        getPokemons()
    }

    private fun getPokemons() {
        val service = Api.retrofitService.getAllPokemon()
        service.enqueue(object : Callback<PokedexData>{
            override fun onResponse(call: Call<PokedexData>, response: Response<PokedexData>) {
                if(response.isSuccessful) {
                    _dataResponse.value = response.body()!!
                    Log.e("Data Response", "${_dataResponse.value}")
                } else {
                    Log.e("Network error", "${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<PokedexData>, t: Throwable) {
                Log.e("Network error", "${t.printStackTrace()}")
            }
        })
    }
}