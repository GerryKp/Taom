package com.gerard.proyectof.ui

sealed class Routes(val route: String) {
    object LoginAct : Routes("login_activity")
    object RegisterAct : Routes("register_activity")
    object RestAct : Routes("rest_activity")

}