package com.maloac.pokedex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maloac.pokedex.components.models.DrawerMenuData

@Composable
fun PokedexDrawerMenu(scrollState: ScrollState) {
    val menuList = listOf(
        DrawerMenuData.Divider,
        DrawerMenuData.AllGenerationsHeader,
        DrawerMenuData.Divider,
        DrawerMenuData.AllGenerations,
        DrawerMenuData.FirstGeneration,
        DrawerMenuData.SecondGeneration,
        DrawerMenuData.Divider,
        DrawerMenuData.OtherInformations,
        DrawerMenuData.Divider,
        DrawerMenuData.ApiInformation
    )
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        Text(text = "Poke Menu",
            color = Color.Red,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
        
         menuList.forEach {
            item ->
            when {
                item.isDivider -> {
                    Divider(modifier = Modifier.padding(bottom = 20.dp, top = 20.dp))
                }
                item.isHeader -> {
                  Text(text = item.title!!, fontWeight = FontWeight.Light,
                  modifier = Modifier.padding(start = 20.dp, end = 20.dp))
                }
                else -> {
                    PokedexDrawerMenu(item = item)
                }
            }
        }
    }
}


@Composable
fun PokedexDrawerMenu(item: DrawerMenuData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 16.dp)
    ) {
        Image(imageVector = item.icon!!, contentDescription = item.title!!,
        modifier = Modifier.weight(0.5f))
        Text(text = item.title, modifier = Modifier.weight(2.0f))
    }
}