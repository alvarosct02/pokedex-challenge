package com.asct94.pokedexchallenge.ui.pokemon.list

import androidx.lifecycle.ViewModel
import com.asct94.pokedexchallenge.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    val pokemonList = repository.fetchPokemonList(0, {}, {}, {})

}