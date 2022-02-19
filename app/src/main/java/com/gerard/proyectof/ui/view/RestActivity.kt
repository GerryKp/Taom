package com.gerard.proyectof.ui.view

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.gerard.proyectof.R
import com.gerard.proyectof.entities.Productos
import com.gerard.proyectof.ui.theme.ProyectofTheme

@Composable
    fun RestActivity (navController: NavController){
        ComponentList()
    }

    @Composable
    fun ComponentList ()
    {
        val viewModel: MainViewModel = viewModel()
        viewModel.insertData()
        var restaurantes = viewModel.restaurantes.observeAsState()

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
            contentPadding = PaddingValues(3.dp),
            reverseLayout = false,
            state =  rememberLazyListState(),
            flingBehavior = ScrollableDefaults.flingBehavior())
        {
            this.item {
                restaurantes.value?.forEach {
                    Component(txt = it.name,desc = it.desc, calle = it.direc, it.num_mesas, it.Productos)
                }

            }
        }
    }

    @Composable
    fun Component (txt: String, desc: String?, calle: String?, mesas:Int?, prods:List<Productos>?){
        var expanded by remember { mutableStateOf(false) }
        val expandedImageMod = Modifier
            .background(MaterialTheme.colors.background)
            .height(100.dp)
            .fillMaxWidth()

        val nonExpandedImageMod = Modifier
            .size(120.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.background)
            .height(100.dp)
            .width(80.dp)

        Crossfade(targetState = expanded, animationSpec = tween(700,100)) { exp -> Boolean
            when (exp)
            {
                true -> {
                    Column (modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                        .background(MaterialTheme.colors.background)
                        .clickable {
                            expanded = !expanded
                        })
                    {
                        ComponentImage(expandedImageMod)
                        ComponentText(txt,desc,calle,true,mesas,prods)
                    }
                }
                false -> {
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                        .background(MaterialTheme.colors.background)
                        .clickable {
                            expanded = !expanded
                        })
                    {
                        ComponentImage(nonExpandedImageMod)
                        ComponentText(txt,desc,calle,false, mesas,prods)
                    }
                }
            }
        }
    }

    @Composable
    fun ComponentText (txt: String,desc:String?,calle:String?,expanded: Boolean,mesas: Int?, prods: List<Productos>?)
    {
        var nomProds = ""
        if (expanded)
            Column(modifier = Modifier.padding(5.dp)) {
                Text(text = txt,
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.h4)

                Text(text = "$calle\n$desc\nNº Mesas: $mesas",
                    style = MaterialTheme.typography.body2,
                    fontSize = 21.sp,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.wrapContentSize())

                prods?.forEach {
                    nomProds += it.name+";  "
                }

                Text(text = "Productos: "+nomProds,
                    style = MaterialTheme.typography.body2,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.wrapContentSize())

            }
        else
            Column(modifier = Modifier.padding(5.dp)) {
                Text(
                    text = txt,
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = calle+"\n"+desc+"\n",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.secondary,
                    fontSize = 21.sp,
                    maxLines = 2
                )
            }
    }

    @Composable
    fun ComponentImage(modifier: Modifier){


        //me quiero suicidar, 4 h para enontrar un método de mierda, voy colgarme del cuello pq me cago en la puta
        // tódo para un 7 de mierda por no usar la api de google
        Image(
            painter = painterResource(R.drawable.restaurantedf),
            contentDescription = null,
            modifier = modifier
        )

    }

