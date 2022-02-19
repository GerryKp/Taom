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

@Composable
fun RegisterActivity(navController: NavController) {

    val nameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val confirmPasswordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.logoapp),"logo",
                Modifier
                    .clip(
                        RectangleShape)
                    .width(150.dp)
                    .height(150.dp))

            Spacer(modifier = Modifier.padding(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .scrollable(rememberScrollState(), orientation = Orientation.Vertical),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign Up", fontSize = 30.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = nameValue.value,
                        onValueChange = { nameValue.value = it },
                        label = { Text(text = "Name") },
                        placeholder = { Text(text = "Your name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        label = { Text(text = "Email Address") },
                        placeholder = { Text(text = "example@mail.com") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
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

                    OutlinedTextField(
                        value = confirmPasswordValue.value,
                        onValueChange = { confirmPasswordValue.value = it },
                        label = { Text(text = "Confirm Password") },
                        placeholder = { Text(text = "Confirm Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        trailingIcon = {
                            IconButton(onClick = {
                                confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                            }) {
                                Icon(
                                    imageVector = if (passwordVisibility.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,

                                    "aaaaa",
                                    tint = if (confirmPasswordVisibility.value) MaterialTheme.colors.primary else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.padding(10.dp))

                    Button(onClick = { navHostController.navigate(Routes.RestAct.route)},
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)) {
                        Text(text = "Sign Up", fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = "Login Instead",
                            modifier = Modifier.clickable(onClick = {
                                navHostController.navigate(Routes.LoginAct.route)
                            })
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                }

            }
        }
    }

