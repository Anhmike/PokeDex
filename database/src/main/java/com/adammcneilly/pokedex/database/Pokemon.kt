package com.adammcneilly.pokedex.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pokemon(
    @PrimaryKey val name: String = "",
    @Embedded val sprites: Sprites? = null,
    val url: String? = null,
    val types: List<TypeSlot>? = null
)