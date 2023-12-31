package com.maloac.pokedex

import com.maloac.pokedex.components.models.PokedexData

object MockData {
    val pokedexData = listOf<PokedexData>(
        PokedexData(
            id = 1,
            order = 1,
            name = "Bulbasaur",
            height = 10,
            weight = 20,
            baseExperience = 10
        ),
        PokedexData(
            id = 2,
            order = 2,
            name = "Ivysaur"
        ),
        PokedexData(
            id = 3,
            order = 3,
            name = "Venasaur"
        ),
        PokedexData(
            id = 4,
            order = 4,
            name = "Charmander"
        ),
        PokedexData(
            id = 5,
            order = 5,
            name = "Charmeleon"
        ),
        PokedexData(
            id = 6,
            order = 6,
            name = "Blastoise"
        )
    )

    fun getById(id: Int?): PokedexData {
        return pokedexData.first{ it.id == id}
    }
}

