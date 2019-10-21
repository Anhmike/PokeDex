package com.adammcneilly.pokedex.models

import com.adammcneilly.pokedex.database.models.TypeSlotDTO

data class TypeSlot(
    val slot: Int? = null,
    val type: Type? = null
) {

    fun toTypeSlotDTO(): TypeSlotDTO {
        return TypeSlotDTO(
            slot = this.slot,
            type = this.type?.toTypeDTO()
        )
    }

    companion object {
        fun fromTypeSlotDTO(dto: TypeSlotDTO?): TypeSlot? {
            return dto?.let {
                TypeSlot(
                    slot = dto.slot,
                    type = Type.fromTypeDTO(dto.type)
                )
            }
        }
    }
}