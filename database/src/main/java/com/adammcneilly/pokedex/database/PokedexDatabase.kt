package com.adammcneilly.pokedex.database

import android.content.Context
import com.adammcneilly.pokedex.database.models.PokemonDTO
import com.adammcneilly.pokedex.database.room.RoomPokedexDatabase

class PokedexDatabase(context: Context) {
    private val roomDatabase = RoomPokedexDatabase.getInMemoryDatabase(context)

    suspend fun insertPokemon(pokemon: PokemonDTO): Long {
        return roomDatabase.pokemonDao().insert(pokemon)
    }

    suspend fun getPokemonByName(name: String): PokemonDTO? {
        return roomDatabase.pokemonDao().getPokemonByName(name)
    }
}