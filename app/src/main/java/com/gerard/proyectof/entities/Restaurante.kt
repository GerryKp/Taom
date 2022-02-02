package com.gerard.proyectof.entities

import android.media.Image
import androidx.room.*
import androidx.room.ColumnInfo.*

@Entity (tableName = "Restaurante")
data class Restaurante (
    @PrimaryKey(autoGenerate = true)
    val id_r: Int = 0,
    @ColumnInfo(name = "Nombre")
    val name: String,
    @ColumnInfo(name = "Productos")
    val Productos : List<Productos>,
    @ColumnInfo(name = "NumMesas")
    val num_mesas: Int,
    @ColumnInfo
    val desc: String?,
    @ColumnInfo
    val direc: String?,
    @ColumnInfo(typeAffinity = BLOB)
    val img: Image?
)
