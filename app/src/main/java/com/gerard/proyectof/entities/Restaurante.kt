package com.gerard.proyectof.entities

import android.graphics.Bitmap
import androidx.room.*
import androidx.room.ColumnInfo.*

@Entity (tableName = "Restaurantes")
data class Restaurante(
    @PrimaryKey(autoGenerate = true)
    val id_r: Int?,

    @ColumnInfo(name = "Nombre")
    val name: String,

    @ColumnInfo(name = "Productos")
    val Productos: List<Productos>?,

    @ColumnInfo(name = "NumMesas")
    val num_mesas: Int?,

    @ColumnInfo
    val desc: String?,
    @ColumnInfo
    val direc: String?,

)
