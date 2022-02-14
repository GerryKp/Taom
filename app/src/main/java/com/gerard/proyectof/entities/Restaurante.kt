package com.gerard.proyectof.entities

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

    @ColumnInfo(typeAffinity = BLOB)
    val img: ByteArray?

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Restaurante

        if (id_r != other.id_r) return false
        if (name != other.name) return false
        if (Productos != other.Productos) return false
        if (num_mesas != other.num_mesas) return false
        if (desc != other.desc) return false
        if (direc != other.direc) return false
        if (img != null) {
            if (other.img == null) return false
            if (!img.contentEquals(other.img)) return false
        } else if (other.img != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id_r ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + (Productos?.hashCode() ?: 0)
        result = 31 * result + (num_mesas ?: 0)
        result = 31 * result + (desc?.hashCode() ?: 0)
        result = 31 * result + (direc?.hashCode() ?: 0)
        result = 31 * result + (img?.contentHashCode() ?: 0)
        return result
    }
}
