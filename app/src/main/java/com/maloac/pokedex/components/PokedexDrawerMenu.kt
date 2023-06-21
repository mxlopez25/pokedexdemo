package com.maloac.pokedex.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokedexDraweMenu() {
    Text(text = "Drawer Menu",
        color = Color.Red,
        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp)
}