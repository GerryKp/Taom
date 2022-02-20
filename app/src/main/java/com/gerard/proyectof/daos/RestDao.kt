package com.gerard.proyectof.daos

import androidx.lifecycle.LiveData
import androidx.room.*;
import com.gerard.proyectof.entities.Productos
import com.gerard.proyectof.entities.Restaurante
//Dao que hará consultas de restaurantes a la base de datos
@Dao
interface RestDao {
    @Query("SELECT * FROM Restaurantes")
    fun getAll(): LiveData<List<Restaurante>>

    @Query("SELECT * FROM Restaurantes WHERE id_r IN (:restIds)")
    fun loadAllByIds(restIds: IntArray): LiveData<List<Restaurante>>

    @Query("SELECT * FROM Restaurantes")
    fun loadAll(): LiveData<List<Restaurante>>

    @Query(
        "SELECT * FROM Restaurantes WHERE nombre LIKE :nomRes"
    )
    fun findByName(nomRes: String): Restaurante

    @Insert
    fun insertOne(rest: Restaurante)

    @Insert
    fun insertAll(rest: List<Restaurante>)

    @Delete
    fun delete(rest: Restaurante)
}