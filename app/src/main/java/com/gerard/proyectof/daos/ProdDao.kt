package com.gerard.proyectof.daos

import androidx.lifecycle.LiveData
import androidx.room.*;
import com.gerard.proyectof.entities.Productos

@Dao
interface ProdDao {
    @Query("SELECT * FROM Productos")
    fun getAll(): LiveData<List<Productos>>

    @Query("SELECT * FROM Productos WHERE id IN (:restIds)")
    fun loadAllByIds(restIds: IntArray): LiveData<List<Productos>>

    @Query(
        "SELECT * FROM Productos WHERE nombre LIKE :nombre")
    fun findByName(nombre: String): Productos

    @Insert
    fun insertAll(productos: List<Productos>)

    @Delete
    fun delete(prod: Productos)
}