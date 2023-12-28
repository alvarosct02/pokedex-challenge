package com.asct94.pokedexchallenge.data.repository

import com.asct94.pokedexchallenge.data.network.model.mapper.asDomain
import com.asct94.pokedexchallenge.data.network.service.PokedexDataSource
import com.asct94.pokedexchallenge.domain.Pokemon
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class PokemonRepositoryImpl @Inject constructor(
    private val pokedexDataSource: PokedexDataSource
) : PokemonRepository {

    override fun fetchPokemon(
        name: String,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<Pokemon> {
        TODO("Not yet implemented")
    }

    override fun fetchPokemonList(
        page: Int,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) = flow {
        val pagedPokeList = pokedexDataSource.fetchPokemonList(page)
        emit(pagedPokeList.asDomain())
    }.onStart { onStart() }.onCompletion { onComplete() }.flowOn(Dispatchers.IO)

}