package com.gerard.proyectof.daos

import androidx.lifecycle.LiveData
import androidx.room.*;
import com.gerard.proyectof.entities.Productos
import com.gerard.proyectof.entities.Restaurante

interface RestDao {
    @Query("SELECT * FROM Restaurante")
    fun getAll(): LiveData<List<Restaurante>>

    @Query("SELECT * FROM Restaurante WHERE id_r IN (:restIds)")
    fun loadAllByIds(restIds: IntArray): LiveData<List<Restaurante>>

    @Query(
        "SELECT * FROM restaurante WHERE nombre LIKE :nomRes LIMIT 1"
    )
    fun findByName(nomRes: String): Restaurante

    @Insert
    fun insertAll(vararg rest: Restaurante)

    @Delete
    fun delete(rest: Restaurante)
}