package com.adammcneilly.pokedex.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.adammcneilly.pokedex.database.models.PokemonDTO

@Dao
interface RoomPokemonDAO {
    @Insert
    suspend fun insert(pokemon: PokemonDTO): Long

    @Query("DELETE FROM PokemonDTO")
    suspend fun deleteAllPokemon(): Int

    @Query("SELECT * FROM PokemonDTO WHERE name = :name")
    suspend fun getPokemonByName(name: String): PokemonDTO?
}