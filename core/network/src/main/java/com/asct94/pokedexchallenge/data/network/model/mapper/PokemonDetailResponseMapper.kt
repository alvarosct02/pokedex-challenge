package com.asct94.pokedexchallenge.data.network.model.mapper

import com.asct94.pokedexchallenge.data.network.model.PokemonDetailResponse
import com.asct94.pokedexchallenge.domain.Pokemon
import com.asct94.pokedexchallenge.domain.Stats
import com.asct94.pokedexchallenge.domain.Type

object PokemonDetailResponseMapper :
    NetworkMapper<Pokemon, PokemonDetailResponse> {
    override fun asDomain(entity: PokemonDetailResponse) = with(entity) {
        Pokemon(
            id = id,
            name = name,
            weight = weight,
            height = height,
            types = types.map { Type(it.type.name) },
            abilities = emptyList(),
            moves = emptyList(),
            stats = Stats(
                hp = getStat(HP),
                attack = getStat(ATTACK),
                defense = getStat(DEFENSE),
                speed = getStat(SPEED),
                specialAttack = getStat(SPECIAL_ATTACK),
                specialDefense = getStat(SPECIAL_DEFENSE),
            ),
        )
    }

    private fun PokemonDetailResponse.getStat(stat: String): Int =
        this.stats.find { it.stat.name == stat }?.baseState ?: 0

    private const val HP = "hp"
    private const val ATTACK = "attack"
    private const val DEFENSE = "defense"
    private const val SPEED = "speed"
    private const val SPECIAL_ATTACK = "special-attack"
    private const val SPECIAL_DEFENSE = "special-defense"
}

fun List<PokemonDetailResponse>?.asDomain(): List<Pokemon> {
    return this?.map { PokemonDetailResponseMapper.asDomain(it) }.orEmpty()
}
