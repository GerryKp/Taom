package com.gerard.proyectof

import android.app.Application
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.gerard.proyectof.entities.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import java.io.ByteArrayOutputStream

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val db by lazy { AppDatabase.getDatabase(application.applicationContext)}
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
        if(!inserted)
        {
            viewModelScope.launch (Dispatchers.IO){

                val prods = listOf(Productos(1,"Cafe Americano",1.5f,"Café de máquina solo",1),
                    Productos(2,"Tostada Aceite",2f,"Tostada con aceite y sal",1),
                    Productos(3,"Tostada Tomate",2.5f,"Tostada con tomate",1))
                val restaurantes: List<Restaurante> = listOf(
                    Restaurante(1, "Restaurante 1",prods,2,"res1","Avenida Constitución 1", null),
                    Restaurante(2, "Restaurante 2",prods,2,"res2","Avenida Constitución 2", null),
                    Restaurante(3, "Restaurante 3",prods,3,"res3","Avenida Constitución 3", null),
                    Restaurante(4, "Restaurante 4",prods,4,"res4","Avenida Constitución 4", null),
                    Restaurante(5, "Restaurante 5",prods,3,"res5","Avenida Constitución 5", null),
                    Restaurante(6, "Restaurante 6",prods,5,"res6","Avenida Constitución 6", null),
                    Restaurante(7, "Restaurante 7",prods,3,"res7","Avenida Constitución 7", null),
                )
                restdao.insertAll(restaurantes)
                prodDao.insertAll(prods)
                inserted = true
            }
        }
    }

}