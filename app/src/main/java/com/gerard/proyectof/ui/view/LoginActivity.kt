package com.gerard.proyectof.ui.view

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gerard.proyectof.R
import com.gerard.proyectof.ui.Routes

@Composable
fun LoginActivity(navController: NavController) {

    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
      Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(10.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.logoapp), contentDescription ="logo",
                Modifier
                    .clip(
                        RectangleShape
                    )
                    .width(150.dp)
                    .height(150.dp))
            Spacer(modifier = Modifier.padding(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Bienvenido/a, gracias por elegirnos un día más",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    ),
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = {emailValue.value = it},
                        modifier =Modifier.fillMaxWidth(0.8f),
                        true,
                        label = { Text(text = "Email Address")},
                        placeholder = { Text(text = "example@mail.com")},
                        singleLine = true,
                    )
                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange ={passwordValue.value = it},
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .focusRequester(focusRequester),
                        label = {Text(text = "Password")},
                        placeholder ={ Text(text = "Password")},
                        trailingIcon = {IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {

                            Icon(
                                imageVector = if (passwordVisibility.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                "eye image for password",
                                tint = if (passwordVisibility.value) MaterialTheme.colors.primary else Color.Gray
                            )
                        }},
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Button(
                        onClick = {navController.navigate(Routes.RestAct.route){
                            launchSingleTop = true
                        }},
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp).background(MaterialTheme.colors.primary)
                    ) {
                        Text(text = "Sign In", fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = "Create An Account",
                        modifier = Modifier.clickable(onClick = {
                            navController.navigate(Routes.RegisterAct.route){
                                launchSingleTop = true
                            }
                        })
                    )
                }


            }
        }

    }

