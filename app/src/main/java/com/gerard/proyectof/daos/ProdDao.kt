package com.gerard.proyectof.daos

import androidx.room.*;
import com.gerard.proyectof.entities.Productos

interface ProdDao {
    @Query("SELECT * FROM Productos")
    fun getAll(): List<Productos>

    @Query("SELECT * FROM Productos WHERE id IN (:restIds)")
    fun loadAllByIds(restIds: IntArray): List<Productos>

    @Query(
        "SELECT * FROM Productos WHERE nombre LIKE :nombre LIMIT 1")
    fun findByName(nombre: String): Productos

    @Insert
    fun insertAll(vararg productos: Productos)

    @Delete
    fun delete(prod: Productos)
}