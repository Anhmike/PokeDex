package com.adammcneilly.pokedex.database

import android.content.Context
import com.adammcneilly.pokedex.database.models.Pokemon
import com.adammcneilly.pokedex.database.room.RoomPokedexDatabase

class PokedexDatabase(context: Context) {
    private val roomDatabase = RoomPokedexDatabase.getInMemoryDatabase(context)

    suspend fun insertPokemon(pokemon: Pokemon): Long {
        return roomDatabase.pokemonDao().insert(pokemon)
    }

    suspend fun getPokemonByName(name: String): Pokemon? {
        return roomDatabase.pokemonDao().getPokemonByName(name)
    }
}