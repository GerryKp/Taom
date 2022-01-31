package com.gerard.proyectof.entities
import androidx.room.*

@Entity(tableName =  "Productos")
data class Productos(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "Nombre")
    val name: String,
    @ColumnInfo(name = "Precio")
    val precio: Float?,
    @ColumnInfo(name = "Descripcion")
    val desc: String
)
