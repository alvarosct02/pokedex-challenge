package com.asct94.pokedexchallenge.data.repository

import androidx.annotation.WorkerThread
import com.asct94.pokedexchallenge.domain.Pokemon
import com.asct94.pokedexchallenge.domain.PokemonRef
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    @WorkerThread
    fun fetchPokemon(
        name: String,
        onComplete: () -> Unit,
        onError: (String?) -> Unit,
    ): Flow<Pokemon>

    @WorkerThread
    fun fetchPokemonList(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit,
    ): Flow<List<PokemonRef>>
}