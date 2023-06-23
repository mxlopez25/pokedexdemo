package com.maloac.pokedex.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.maloac.pokedex.R
import com.maloac.pokedex.components.models.PokedexData

@Composable
fun PokemonDetailsScreen(
    navController: NavController,
    pokemonData: PokedexData,
    scrollState: ScrollState
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        BoxWithConstraints {
            ConstraintLayout(portraitConstraints(15.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Sample Image",
                    modifier = Modifier
                        .layoutId("pokemonImage")
                        .height(200.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )

                Text(
                    modifier = Modifier.layoutId("pokemonName"),
                    text = "#${pokemonData.order} ${pokemonData.name}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )

                Text(
                    modifier = Modifier.layoutId("pokemonHeight"),
                    text = "Height: ${pokemonData.height}"
                )
                Text(
                    modifier = Modifier.layoutId("pokemonWeight"),
                    text = "Weight: ${pokemonData.weight}"
                )
                Text(
                    modifier = Modifier.layoutId("baseExperience"),
                    text = "Base Experience: ${pokemonData.baseExperience}"
                )
            }
        }
    }
}


private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("pokemonImage")
        val name = createRefFor("pokemonName")
        val height = createRefFor("pokemonHeight")
        val weight = createRefFor("pokemonWeight")
        val baseExperience = createRefFor("baseExperience")

        constrain(image) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(name) {
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(height) {
            top.linkTo(name.bottom)
            start.linkTo(parent.start)
        }
        constrain(weight) {
            top.linkTo(height.bottom)
            start.linkTo(parent.start)
        }
        constrain(baseExperience) {
            top.linkTo(weight.bottom)
            start.linkTo(parent.start)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailsScreenPreview() {
    PokemonDetailsScreen(
        navController = rememberNavController(), PokedexData(id = 1, order = 1, name = "Bulbasaur"),
        rememberScrollState()
    )
}