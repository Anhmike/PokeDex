package com.adammcneilly.pokedex.database.room

import androidx.room.TypeConverter
import com.adammcneilly.pokedex.database.models.TypeSlotDTO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeSlotListConverter {

    @TypeConverter
    fun fromTypeSlotList(value: List<TypeSlotDTO>?): String {
        val gson = Gson()
        val type = object : TypeToken<List<TypeSlotDTO>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toTypeSlotList(value: String?): List<TypeSlotDTO>? {
        val gson = Gson()
        val type = object : TypeToken<List<TypeSlotDTO>>() {}.type
        return gson.fromJson(value, type)
    }
}