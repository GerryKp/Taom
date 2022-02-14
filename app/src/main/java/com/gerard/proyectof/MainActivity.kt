package com.gerard.proyectof

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gerard.proyectof.ui.theme.ProyectofTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectofTheme {
                ComponentPreview()
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ComponentPreview (){
    ComponentList()
}

@Composable
fun ComponentList ()
{
    val viewModel:MainViewModel = viewModel()
    viewModel.insertData()
    var restaurantes = viewModel.restaurantes.observeAsState()

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray),
        contentPadding = PaddingValues(3.dp),
        reverseLayout = false,
        state =  rememberLazyListState(),
        flingBehavior = ScrollableDefaults.flingBehavior())
    {
        this.item {
            restaurantes.value?.forEach {
                Component(txt = it.name)
            }

        }
    }
}

@Composable
fun Component (txt: String){
    var expanded by remember { mutableStateOf(false)}
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

    Crossfade(targetState = expanded, animationSpec = tween(1100)) {exp -> Boolean
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
                        ComponentText(txt,true)
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
                        ComponentText(txt,false)
                    }
                }
            }
        }
}

@Composable
fun ComponentText (txt: String,expanded: Boolean){

    if (expanded)
    Column(modifier = Modifier.padding(5.dp)) {
        Text(text = txt,
            color = MaterialTheme.colors.primary,
        style = MaterialTheme.typography.h4)
        Text(text = "Aquí va el rating y tal ya haré el " +
                "desplegable AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
        style = MaterialTheme.typography.body2,
        fontSize = 21.sp,
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
                text = "Aquí va el rating y tal ya haré el desplegwdcwwcwcwcwcw" +
                        "ceocpincwncpw" +
                        "eccwecewable AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.secondary,
                fontSize = 21.sp,
                maxLines = 2
            )
        }
}

@Composable
fun ComponentImage(modifier: Modifier){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Image_Component",
        modifier = modifier
    )
}
