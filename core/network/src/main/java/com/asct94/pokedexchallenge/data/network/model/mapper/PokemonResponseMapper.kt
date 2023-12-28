package com.asct94.pokedexchallenge.data.network.model.mapper

import com.asct94.pokedexchallenge.data.network.model.PokemonEntity
import com.asct94.pokedexchallenge.data.network.model.PokemonResponse
import com.asct94.pokedexchallenge.domain.PokemonRef

object PokemonResponseMapper :
    NetworkMapper<List<PokemonRef>, PokemonResponse> {
    override fun asDomain(entity: PokemonResponse) = with(entity) {
        results.map {
            PokemonRef(
                id = it.getId(),
                name = it.name,
                url = it.url
            )
        }
    }

    private fun PokemonEntity.getId(): Int = this.url.split('/').dropLast(1).last().toIntOrNull() ?: 0

}

fun PokemonResponse?.asDomain(): List<PokemonRef> {
    return this?.let { PokemonResponseMapper.asDomain(it) }.orEmpty()
}
