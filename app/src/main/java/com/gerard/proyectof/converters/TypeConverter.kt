package com.gerard.proyectof.converters

import com.gerard.proyectof.entities.Productos
import com.gerard.proyectof.entities.Restaurante
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import androidx.room.TypeConverter

class TypeConverter {

    @TypeConverter
    fun fromCountryLangList(countryLang: List<Productos?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Productos?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toCountryLangList(countryLangString: String?): List<Productos?>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Productos?>?>() {}.type
        return gson.fromJson(countryLangString, type)
    }
}