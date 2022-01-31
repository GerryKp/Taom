package com.gerard.proyectof.entities

import androidx.room.*

@Database(entities = [Productos::class, Restaurante::class], version = 1)
abstract class AppDatabase : RoomDatabase()