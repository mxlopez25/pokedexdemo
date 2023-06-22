package com.maloac.pokedex.components.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Grid3x3
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val icon: ImageVector,
    val title: String
    ) {
    object List: BottomMenuData(icon = Icons.Outlined.List, title = "List")
    object Grid: BottomMenuData(icon = Icons.Outlined.Grid3x3, title = "Grid")
}