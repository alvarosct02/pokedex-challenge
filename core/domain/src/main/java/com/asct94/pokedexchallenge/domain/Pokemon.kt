package com.asct94.pokedexchallenge.domain

data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val types: List<Type>,
    val abilities: List<Ability>,
    val moves: List<Move>,
    val stats: Stats,
)

data class Type(
    val name: String,
)

data class Ability(
    val name: String,
    val url: String,
)

data class Move(
    val name: String,
    val url: String,
)

data class Stats(
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val specialAttack: Int,
    val specialDefense: Int,
)