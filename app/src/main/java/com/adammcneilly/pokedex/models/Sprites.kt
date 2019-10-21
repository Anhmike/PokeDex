package com.adammcneilly.pokedex.models

import com.adammcneilly.pokedex.database.models.SpritesDTO
import com.squareup.moshi.Json

data class Sprites(
    @field:Json(name = "front_default")
    val frontDefault: String? = null
) {

    fun toSpritesDTO(): SpritesDTO {
        return SpritesDTO(
            frontDefault = this.frontDefault
        )
    }

    companion object {
        fun fromSpritesDTO(dto: SpritesDTO?): Sprites? {
            return dto?.let {
                Sprites(
                    frontDefault = it.frontDefault
                )
            }
        }
    }
}