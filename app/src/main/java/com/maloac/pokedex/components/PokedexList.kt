package com.maloac.pokedex.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maloac.pokedex.components.models.PokedexData
import com.maloac.pokedex.pokedexData

@Composable
fun PokedexList(paddingValues: PaddingValues) {
    Box(modifier = Modifier.padding(paddingValues)) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            items(pokedexData) {
                pokemonData ->
                PokedexItem(pokedexData = pokemonData)
            }
        }
    }
}

@Composable
fun PokedexItem(pokedexData: PokedexData, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Card(
            modifier = Modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape),
        backgroundColor = Color.Gray
        ) {
            Text(text = pokedexData.id.toString(), textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp))
        }
        Column(modifier = Modifier.weight(2.0f)) {
            Text(
                text = pokedexData.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }

        Column() {

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(50.dp)
            ) {
                Icon(imageVector = Icons.Outlined.StarOutline, contentDescription = "Favorites")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MailItemPreview() {
    PokedexItem(
        pokedexData = PokedexData(
            id = 1,
            name = "Bulbasaur",
            height = 100,
            order = 1,
            weight = 100
        )
    )
}