package com.gerard.proyectof.converters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.gerard.proyectof.entities.Productos
import com.gerard.proyectof.entities.Restaurante
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream
//Clase para convertir las listas de productos de los restuarantes a gson y que room las pueda almacenar
class TypeConverter {

    @TypeConverter
    fun fromProductList(countryLang: List<Productos?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Productos?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toProductList(countryLangString: String?): List<Productos?>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Productos?>?>() {}.type
        return gson.fromJson(countryLangString, type)
    }

    // Esos 2 conversores ya no hacen falta, pero los dejo implementados por si las moscas
    //Servían para guardar imágenes pero dan más problemas que veces funcionan
    @TypeConverter
    fun fromBitmap(bitmap: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }

    @TypeConverter
    fun toBitmap(byteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }
}