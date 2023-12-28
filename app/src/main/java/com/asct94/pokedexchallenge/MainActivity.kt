package com.asct94.pokedexchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.asct94.pokedexchallenge.ui.pokemon.list.PokemonListScreen
import com.asct94.pokedexchallenge.ui.theme.PokedexChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexChallengeTheme {
                PokemonListScreen()
            }
        }
    }
}