package com.gerard.proyectof.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gerard.proyectof.R
import com.gerard.proyectof.ui.Routes

//Composable que contiene la vista de registro con todos sus elementos
// mejora a futuro: separar los outlinedtextbox a composables propios
@Composable
fun RegisterActivity(navController: NavController) {
    //Valores necesarios que se obtendrán de la base de datos
    val nameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val confirmPasswordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }
    //Columna principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoapp), "logo",
                Modifier
                    .clip(
                        RectangleShape
                    )
                    .width(150.dp)
                    .height(150.dp)
            )
            //Columna Secundaria con los campos de texto
            Column(
                modifier = Modifier
                    .fillMaxSize(0.8f)
                    .scrollable(rememberScrollState(), orientation = Orientation.Vertical),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign Up", fontSize = 30.sp,
                    color = MaterialTheme.colors.primaryVariant,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))
                //TextField para el nombre del usuario
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = nameValue.value,
                        onValueChange = { nameValue.value = it },
                        label = { Text(text = "Name") },
                        placeholder = { Text(text = "Your name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.9f)
                    )
                    //TextField para mail de usuario
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        label = { Text(text = "Email Address") },
                        placeholder = { Text(text = "example@mail.com") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.9f)
                    )
                    //TextField para contraseña
                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.9f),
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                Icon(
                                    imageVector = if (passwordVisibility.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                    "aaaa",
                                    tint = if (passwordVisibility.value) MaterialTheme.colors.primary else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    //TextField para confirmar contraseña
                    OutlinedTextField(
                        value = confirmPasswordValue.value,
                        onValueChange = { confirmPasswordValue.value = it },
                        label = { Text(text = "Confirm Password") },
                        placeholder = { Text(text = "Confirm Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.9f),
                        trailingIcon = {
                            IconButton(onClick = {
                                confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                            }) {
                                Icon(
                                    imageVector = if (confirmPasswordVisibility.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,

                                    "aaaaa",
                                    tint = if (confirmPasswordVisibility.value) MaterialTheme.colors.primary else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    //Botón para registrarse y dar paso a la vista de restaurantes
                    Button(
                        onClick = { navHostController.navigate(Routes.RestAct.route) },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp).background(MaterialTheme.colors.primaryVariant)
                    ) {
                        Text(text = "Sign Up", fontSize = 20.sp)
                    }
                    //Botón para navegar a la vista de login
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = "Login Instead",
                        color = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier.clickable(onClick = {
                            navHostController.navigate(Routes.LoginAct.route)
                        })
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                }

            }
        }
}

