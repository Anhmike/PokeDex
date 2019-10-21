package com.adammcneilly.pokedex.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adammcneilly.pokedex.database.models.PokemonDTO

@Entity
data class Pokemon(
    @PrimaryKey val name: String = "",
    @Embedded val sprites: Sprites? = null,
    val url: String? = null,
    val types: List<TypeSlot>? = null
) {
    val sortedTypes: List<Type>
        get() = types?.sortedBy { it.slot }?.mapNotNull { it.type }.orEmpty()

    fun toPokemonDTO(): PokemonDTO {
        return PokemonDTO(
            name = this.name,
            sprites = this.sprites?.toSpritesDTO(),
            url = this.url,
            types = this.types?.map(TypeSlot::toTypeSlotDTO)
        )
    }

    companion object {
        fun fromPokemonDTO(dto: PokemonDTO?): Pokemon? {
            return dto?.let {
                Pokemon(
                    name = dto.name,
                    sprites = Sprites.fromSpritesDTO(dto.sprites),
                    url = dto.url,
                    types = dto.types?.mapNotNull(TypeSlot.Companion::fromTypeSlotDTO)
                )
            }
        }
    }
}