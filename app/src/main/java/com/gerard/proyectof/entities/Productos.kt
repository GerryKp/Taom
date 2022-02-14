package com.gerard.proyectof.entities
import androidx.room.*

@Entity(foreignKeys = [ForeignKey(entity = Restaurante::class,
    parentColumns = arrayOf("id_r"),
    childColumns = arrayOf("idRest"),
    onDelete = ForeignKey.CASCADE)])
data class Productos(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "Nombre")
    val name: String,
    @ColumnInfo(name = "Precio")
    val precio: Float?,
    @ColumnInfo(name = "Descripcion")
    val desc: String,

    @ColumnInfo(name="idRest")
    val id_rest: Int
)
