package com.gerard.proyectof.entities

import android.media.Image
import androidx.room.*
import androidx.room.ColumnInfo.*

@Entity (tableName = "Restaurante")
data class Restaurante (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "Nombre")
    val name: String,
    @ColumnInfo(name = "Productos")
    val Productos : List<Productos>,
    @ColumnInfo(name = "")
    val num_mesas: Int,
    @ColumnInfo(typeAffinity = BLOB)
    val img:Image
)
