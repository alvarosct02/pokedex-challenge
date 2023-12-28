package com.asct94.pokedexchallenge.data.network.service

import com.asct94.pokedexchallenge.data.network.model.PokemonDetailResponse
import com.asct94.pokedexchallenge.data.network.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): PokemonResponse

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(@Path("name") name: String): PokemonDetailResponse
}