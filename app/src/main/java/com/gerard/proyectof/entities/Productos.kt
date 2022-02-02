package com.gerard.proyectof.entities
import androidx.room.*

@Entity(foreignKeys = [ForeignKey(entity = Productos::class,
    parentColumns = arrayOf("id_r"),
    childColumns = arrayOf("Id_Rest"),
    onDelete = ForeignKey.CASCADE)], tableName = "Productos")
data class Productos(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "Nombre")
    val name: String,
    @ColumnInfo(name = "Precio")
    val precio: Float?,
    @ColumnInfo(name = "Descripcion")
    val desc: String,

    @ColumnInfo(name="Id_Rest")
    val id_rest: Restaurante
)
