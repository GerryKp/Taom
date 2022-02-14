package com.gerard.proyectof.repo

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.gerard.proyectof.daos.ProdDao
import com.gerard.proyectof.entities.Productos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class ProdRepo (private val prodDao: ProdDao) {
    // Declares the DAO as a private property in the constructor. Pass in the DAO
    // instead of the whole database, because you only need access to the DAO

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allResId: LiveData<List<Productos>> = prodDao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(prod: List<Productos>) {
        prodDao.insertAll(prod)
    }
}
