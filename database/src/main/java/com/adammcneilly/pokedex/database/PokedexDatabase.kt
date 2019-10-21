package com.adammcneilly.pokedex.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [(Pokemon::class)], version = 1)
@TypeConverters((TypeSlotListConverter::class))
abstract class PokedexDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDAO

    companion object {
        private var INSTANCE: PokedexDatabase? = null

        fun getInMemoryDatabase(context: Context): PokedexDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    PokedexDatabase::class.java, "pokedex.db"
                )
                    .build()
            }

            return INSTANCE!!
        }
    }
}