package com.adammcneilly.pokedex.database.room

import androidx.room.TypeConverter
import com.adammcneilly.pokedex.database.models.TypeSlot
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeSlotListConverter {

    @TypeConverter
    fun fromTypeSlotList(value: List<TypeSlot>?): String {
        val gson = Gson()
        val type = object : TypeToken<List<TypeSlot>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toTypeSlotList(value: String?): List<TypeSlot>? {
        val gson = Gson()
        val type = object : TypeToken<List<TypeSlot>>() {}.type
        return gson.fromJson(value, type)
    }
}