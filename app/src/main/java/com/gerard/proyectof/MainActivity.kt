package com.gerard.proyectof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gerard.proyectof.ui.theme.ProyectofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectofTheme {
                ComponentPreview()
            }
        }
    }
}
//Acordarse de mirar lo del login por si da tiempo a meterlo
@Preview(showBackground = true)
@Composable
fun ComponentPreview (){
    ComponentList()
}

@Composable
fun ComponentList (){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray),
        contentPadding = PaddingValues(3.dp),
        reverseLayout = false,
        state =  rememberLazyListState(),
        flingBehavior = ScrollableDefaults.flingBehavior())
    {
        this.item {
            Component()
            Component()
            Component()
            Component()
            Component()
            Component()
            Component()
            Component()
            Component()
            Component()
        }
    }
}

@Composable
fun Component (){
    Row (modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .background(MaterialTheme.colors.background)
        .clickable(true, onClick = {

        })){
        ComponentImage()
        ComponentText()
    }
}

@Composable
fun ComponentText (){
    Column(modifier = Modifier.padding(5.dp)) {
        Text(text = "Restaurante1",
        style = MaterialTheme.typography.h4)
        Text(text = "Aquí va el rating y tal ya haré el desplegable",
        style = MaterialTheme.typography.body2,
        fontSize = 21.sp)
    }
}

@Composable
fun ComponentImage (){
    Image(
        painter = painterResource(id = R.drawable.restaurantedf),
        contentDescription = "Image_Component",
        modifier = Modifier
                .size(130.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.background)
                .height(80.dp)
                .width(80.dp)
    )
}
/*fun clickEvent()
{
    var eventObserver
}*/