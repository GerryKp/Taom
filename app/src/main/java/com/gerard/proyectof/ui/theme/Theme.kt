package com.gerard.proyectof.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = LightBrown,
    primaryVariant = Ocre,
    secondary = LightBlue,
        background = Gray
)

private val LightColorPalette = lightColors(
    primary = DarkRed,
    primaryVariant = DarkOcre,
    secondary = DeepBlue,
            background = White
    /* Other default colors to override
    background = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    surface = Color.White,
    */
)

@Composable
fun ProyectofTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}