package com.adammcneilly.pokedex.database.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonDTO(
    @PrimaryKey val name: String = "",
    @Embedded val sprites: SpritesDTO? = null,
    val url: String? = null,
    val types: List<TypeSlotDTO>? = null
)