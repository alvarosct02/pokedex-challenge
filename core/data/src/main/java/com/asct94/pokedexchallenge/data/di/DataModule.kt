package com.asct94.pokedexchallenge.data.di

import com.asct94.pokedexchallenge.data.repository.PokemonRepository
import com.asct94.pokedexchallenge.data.repository.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindsPokemonRepository(pokemonRepository: PokemonRepositoryImpl): PokemonRepository
}
