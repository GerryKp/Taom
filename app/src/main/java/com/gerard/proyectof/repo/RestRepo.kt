package com.gerard.proyectof.repo

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.gerard.proyectof.daos.RestDao
import com.gerard.proyectof.entities.Productos
import com.gerard.proyectof.entities.Restaurante
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.toList

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class RestRepo(private val restdao: RestDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allResId: LiveData<List<Restaurante>> = restdao.getAll()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(res: List<Restaurante>) {
        restdao.insertAll(res)
    }
}