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

    //Conseguimos una instancia de la base de datos
    private val db by lazy { AppDatabase.getDatabase(application.applicationContext)}
    var restdao = db.restDao() //Dao de restaurantes
    var prodDao = db.prodDao() //Dao de productos

    private var _restaurantes: LiveData<List<Restaurante>> = restdao.getAll()
     val restaurantes = _restaurantes

    private var _productos :LiveData<List<Productos>> = prodDao.getAll()
    val productos = _productos

    var inserted = false
    //Función que llama al dao correspondiente para insertar un restaurante en la bd
    fun insertOne(r:Restaurante)
    {
        restdao.insertOne(r)
    }
    //Función que llama al dao correspondiente para insertar una lista de productos en la bd
    fun insertProds(prods: List<Productos>)
    {
        prodDao.insertAll(prods)
    }

    //Función para dotar a la base de datos de unos pocos restaurantes de prueba
    fun insertData()
    {
        if(!inserted) {
            //Creamos un hilo para limpiar la base de datos, ya que si no lo hacemos el hilo principal se sobrecarga
                // y saldría error de compilación
            viewModelScope.launch(Dispatchers.IO) {
                db.clearAllTables()

            }
            //Creamos un hilo para insertar datos y que el hilo principal no se sobrecargue
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
                        "Bufé Libre",
                        "Avenida Constitución 1"

                    ),
                    Restaurante(
                        2,
                        "Restaurante 2",
                        prods,
                        2,
                        "AAAAAAA",
                        "Avenida Constitución 2"

                    ),
                    Restaurante(
                        3,
                        "Restaurante 3",
                        prods,
                        3,
                        "Comida Mexicana",
                        "Avenida Constitución 3"

                    ),
                    Restaurante(
                        4,
                        "Restaurante 4",
                        prods,
                        4,
                        "Bufé Japonés",
                        "Avenida Constitución 4"

                    ),
                    Restaurante(
                        5,
                        "Restaurante 5",
                        prods,
                        3,
                        "Wok Chino",
                        "Avenida Constitución 5"
                    ),
                    Restaurante(
                        6,
                        "Restaurante 6",
                        prods,
                        5,
                        "Chino",
                        "Avenida Constitución 6"),
                    Restaurante(
                        7,
                        "Restaurante 7",
                        prods,
                        3,
                        "Comida Rápida",
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