package com.maloac.pokedex.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.maloac.pokedex.components.models.BottomMenuData

@Composable
fun HomeBottomBar() {
    val items = listOf(BottomMenuData.List, BottomMenuData.Grid)
    BottomNavigation(elevation = 10.dp, backgroundColor = Color.White,
    contentColor = Color.Black) {
        items.forEach {
            BottomNavigationItem(
                selected = false,
                alwaysShowLabel = true,
                onClick = { /*TODO*/ },
                icon = {Icon(imageVector = it.icon, contentDescription = it.title)},
                label = {Text(text = it.title)})
        }
    }
}