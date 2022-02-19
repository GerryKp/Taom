package com.gerard.proyectof.ui.view

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.core.graphics.drawable.toDrawable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.gerard.proyectof.entities.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db by lazy { AppDatabase.getDatabase(application.applicationContext)}
    var restdao = db.restDao()
    var prodDao = db.prodDao()

    private var _restaurantes: LiveData<List<Restaurante>> = restdao.getAll()
     val restaurantes = _restaurantes

    private var _productos :LiveData<List<Productos>> = prodDao.getAll()
    val productos = _productos

    var inserted = false

    fun insertOne(r:Restaurante)
    {
        restdao.insertOne(r)
    }

    fun insertProds(prods: List<Productos>)
    {
        prodDao.insertAll(prods)
    }

    fun insertData()
    {
        if(!inserted) {
            viewModelScope.launch(Dispatchers.IO) {
                db.clearAllTables()

            }
            viewModelScope.launch(Dispatchers.IO) {

                val prods = listOf(
                    Productos(1, "Cafe Americano", 1.5f, "Café de máquina solo", 1),
                    Productos(2, "Tostada Aceite", 2f, "Tostada con aceite y sal", 1),
                    Productos(3, "Tostada Tomate", 2.5f, "Tostada con tomate", 1)
                )
                val restaurantes: List<Restaurante> = listOf(
                    Restaurante(
                        1,
                        "Restaurante 1",
                        prods,
                        2,
                        "Restaurante 1 en Elda",
                        "Avenida Constitución 1"

                    ),
                    Restaurante(
                        2,
                        "Restaurante 2",
                        prods,
                        2,
                        "Restaurante 2 en Elda",
                        "Avenida Constitución 2"

                    ),
                    Restaurante(
                        3,
                        "Restaurante 3",
                        prods,
                        3,
                        "Restaurante 3 en Elda",
                        "Avenida Constitución 3"

                    ),
                    Restaurante(
                        4,
                        "Restaurante 4",
                        prods,
                        4,
                        "Restaurante 4 en Elda",
                        "Avenida Constitución 4"

                    ),
                    Restaurante(
                        5,
                        "Restaurante 5",
                        prods,
                        3,
                        "Restaurante 5 en Elda",
                        "Avenida Constitución 5"
                    ),
                    Restaurante(
                        6,
                        "Restaurante 6",
                        prods,
                        5,
                        "Restaurante 6 en Elda",
                        "Avenida Constitución 6"),
                    Restaurante(
                        7,
                        "Restaurante 7",
                        prods,
                        3,
                        "Restaurante 7 en Elda",
                        "Avenida Constitución 7"
                    ),
                )
                restdao.insertAll(restaurantes)
                prodDao.insertAll(prods)
                inserted = true
            }
        }


    }
}