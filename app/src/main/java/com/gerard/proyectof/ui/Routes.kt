package com.gerard.proyectof.ui
//Clase que nos sirve las rutas de las diferentes actividades para que el navController pueda encontrarlas
sealed class Routes(val route: String) {
    object LoginAct : Routes("login_activity")
    object RegisterAct : Routes("register_activity")
    object RestAct : Routes("rest_activity")

}