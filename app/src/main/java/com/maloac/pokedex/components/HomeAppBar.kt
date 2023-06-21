package com.maloac.pokedex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maloac.pokedex.PokedexApp
import com.maloac.pokedex.ui.theme.PokedexTheme
import com.maloac.pokedex.R

@Composable
fun HomeAppBar() {
    Box(modifier = Modifier.padding(10.dp)) {
        Card(shape = RoundedCornerShape(10.dp), elevation = 6.dp,
        modifier = Modifier.requiredHeight(50.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)) {
                Icon(Icons.Default.Menu, "Menu")
                Text(text = "Search in Pokedex",
                modifier = Modifier.weight(2.0f).padding(2.dp))
                Image(painter = painterResource(id = R.drawable.pokelogo), "Logo",
                modifier = Modifier.size(30.dp).clip(CircleShape).background(color = Color.White)
                )
            }

        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    PokedexTheme {
        PokedexApp()
    }
}