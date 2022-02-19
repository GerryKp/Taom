package com.gerard.proyectof.ui.view

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gerard.proyectof.ui.Routes

lateinit var navHostController: NavHostController

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NavController(navController: NavHostController) {


    /*if(!mainViewModel.anyUser()){
        Log.i("USUARIOS", "NO HAY USUARIOS")
        scope.launch {
            mainViewModel.createSampleUsers()
        }

    }
    if(mainViewModel.anyGroup()){
        groups.value?.let {
            groups.value!!.forEach {
                Log.i("GRUPOS", it.group.name)
                if(!it.users.isEmpty()){
                    it.users.forEach {
                        Log.i("GRUPOS USUARIO", it.name)
                    }
                }

            }
        }
    }*/
    navHostController = navController
    NavHost(
        navController = navController,
        startDestination = Routes.LoginAct.route

    ) {

        composable(route = Routes.LoginAct.route) {
            LoginActivity(navController)

        }
        composable(route = Routes.RegisterAct.route) {
            RegisterActivity(navController)

        }
        composable(route = Routes.RestAct.route) {
            RestActivity(navController)
        }
    }
}