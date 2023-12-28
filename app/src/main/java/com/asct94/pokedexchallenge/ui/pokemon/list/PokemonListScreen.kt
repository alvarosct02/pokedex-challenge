package com.asct94.pokedexchallenge.ui.pokemon.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.asct94.pokedexchallenge.domain.PokemonRef

@Composable
fun PokemonListScreen(
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    val pokemonList by viewModel.pokemonList.collectAsState(emptyList())
    PokemonListScreenContent(pokemonList = pokemonList)
}

@Composable
fun PokemonListScreenContent(
    pokemonList: List<PokemonRef>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(pokemonList) { item ->
            PokemonItem(pokemon = item)
        }
    }
}

@Composable
private fun PokemonItem(
    pokemon: PokemonRef
) {
    Column {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pokemon.getImageUrl())
                .crossfade(true)
                .build(),
            contentDescription = "Image of ${pokemon.name}",
            contentScale = ContentScale.Crop
        )
        Text(text = pokemon.name)
    }
}