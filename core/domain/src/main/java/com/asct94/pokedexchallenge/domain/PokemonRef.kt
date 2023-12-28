package com.asct94.pokedexchallenge.domain

data class PokemonRef(
    val id: Int,
    val name: String,
    val url: String
) {

    fun getImageUrl(): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/other/official-artwork/$id.png"
    }
}