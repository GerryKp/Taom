package com.gerard.proyectof.entities

import android.content.Context
import androidx.room.*
import com.gerard.proyectof.converters.TypeConverter
import com.gerard.proyectof.daos.*

@Database(entities = [Productos::class, Restaurante::class], version = 1)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun prodDao(): ProdDao
    abstract fun restDao(): RestDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null
        //Function that gest a single database connection
        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Restaurantes"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}