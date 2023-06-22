package com.maloac.pokedex.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.maloac.pokedex.components.models.PokedexData

@Composable
fun PokemonDetailsScreen(navController: NavController, pokemonData: PokedexData) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Details Page of ${pokemonData.name}")
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailsScreenPreview() {
    PokemonDetailsScreen(navController = rememberNavController(), PokedexData(id = 1, order = 1, name = "Bulbasaur"))
}