package com.maloac.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maloac.pokedex.components.HomeAppBar
import com.maloac.pokedex.components.HomeBottomBar
import com.maloac.pokedex.components.PokedexDrawerMenu
import com.maloac.pokedex.components.PokedexList
import com.maloac.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PokedexApp()
                }
            }
        }
    }
}

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
        PokedexList(paddingValues = it)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexTheme {
        PokedexApp()
    }
}