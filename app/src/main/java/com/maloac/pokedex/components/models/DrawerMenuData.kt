package com.maloac.pokedex.components.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Accessible
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.material.icons.outlined.Android
import androidx.compose.material.icons.outlined.Dry
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuData (
    val icon: ImageVector? = null, val title: String? = null,
    val isDivider: Boolean = false, val isHeader: Boolean = false
) {
    object AllGenerations: DrawerMenuData(
        icon = Icons.Outlined.AllInbox, title = "All Pokemons"
    )
    object FirstGeneration: DrawerMenuData(
        icon = Icons.Outlined.Dry, title = "1st Gen"
    )
    object SecondGeneration: DrawerMenuData(
        icon = Icons.Outlined.Android, title = "2nd Generation"
    )


    object ApiInformation: DrawerMenuData(
        icon = Icons.Outlined.Accessible, title = "APIs Information"
    )


    object Divider: DrawerMenuData(
        isDivider = true
    )

    object AllGenerationsHeader: DrawerMenuData(
        isHeader = true,
        title = "Generations"
    )
    object OtherInformations: DrawerMenuData(
        isHeader = true,
        title = "Miscs"
    )
}