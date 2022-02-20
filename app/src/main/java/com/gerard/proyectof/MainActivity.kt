package com.gerard.proyectof

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.gerard.proyectof.ui.theme.ProyectofTheme
import com.gerard.proyectof.ui.view.NavController
//Actividad Principal
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectofTheme {
                val navController = rememberNavController()
                NavController(navController = navController)
            }
        }

    }
}

