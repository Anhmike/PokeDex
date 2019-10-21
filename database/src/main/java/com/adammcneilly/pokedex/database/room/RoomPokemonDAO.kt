package com.adammcneilly.pokedex.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.adammcneilly.pokedex.database.models.Pokemon

@Dao
interface RoomPokemonDAO {
    @Insert
    suspend fun insert(pokemon: Pokemon): Long

    @Query("DELETE FROM Pokemon")
    suspend fun deleteAllPokemon(): Int

    @Query("SELECT * FROM Pokemon WHERE name = :name")
    suspend fun getPokemonByName(name: String): Pokemon?
}