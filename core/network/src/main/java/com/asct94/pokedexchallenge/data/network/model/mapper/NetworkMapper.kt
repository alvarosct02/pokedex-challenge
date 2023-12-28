package com.asct94.pokedexchallenge.data.network.model.mapper

interface NetworkMapper<Domain, Entity> {

    fun asDomain(entity: Entity): Domain
}
