package com.gorkius.comida.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = GreenComida,
    primaryVariant = StrongGreenComida,
    secondary = YellowComida,
    secondaryVariant = StrongYellowComida,
    background = DarkGreenComida,
    surface = DarkYellowComida,
    onPrimary = DarkGreyComida,
    onSecondary = BlackComida,
    onBackground = LightYellowComida,
    onSurface = LightGreenComida

)

private val LightColorPalette = lightColors(
    primary = GreenComida,
    primaryVariant = StrongGreenComida,
    secondary = YellowComida,
    secondaryVariant = StrongYellowComida,
    background = LightGreenComida,
    surface = LightYellowComida,
    onPrimary = WhiteComida,
    onSecondary = GreyComida,
    onBackground = DarkYellowComida,
    onSurface = DarkGreenComida
)

@Composable
fun ComidaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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