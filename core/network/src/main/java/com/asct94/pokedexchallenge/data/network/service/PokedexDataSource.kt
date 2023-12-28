package com.asct94.pokedexchallenge.data.network.service

import com.asct94.pokedexchallenge.data.network.model.PokemonDetailResponse
import com.asct94.pokedexchallenge.data.network.model.PokemonResponse
import javax.inject.Inject

class PokedexDataSource @Inject constructor(private val pokeApi: PokeApi) {

    suspend fun fetchPokemonList(page: Int): PokemonResponse = pokeApi.fetchPokemonList(
        limit = PAGING_SIZE,
        offset = page * PAGING_SIZE,
    )

    suspend fun fetchPokemonInfo(name: String): PokemonDetailResponse = pokeApi.fetchPokemonInfo(
        name = name,
    )

    companion object {
        private const val PAGING_SIZE = 20
    }
}