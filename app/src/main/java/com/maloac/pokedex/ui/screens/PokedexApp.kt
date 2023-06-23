package com.maloac.pokedex.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.maloac.pokedex.MockData
import com.maloac.pokedex.components.*

@Composable
fun PokedexApp() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState, coroutineScope) },
        drawerContent = { PokedexDrawerMenu(scrollState) },
        bottomBar = { HomeBottomBar() }
    ) {
        Navigation(it)
    }

}

@Composable
fun Navigation(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    val scrollState = rememberScrollState()

    NavHost(navController = navController, startDestination = "PokedexApp") {
        composable("PokedexApp") {
            PokedexList(navController, paddingValues = paddingValues)
        }
        composable("Detail/{pokemonId}",
            arguments = listOf(navArgument("pokemonId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt("pokemonId")
            PokemonDetailsScreen(navController, pokemonData = MockData.getById(id), scrollState)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokedexAppPreview() {
    PokedexApp()
}