package de.dbaelz.stellar.theme

import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val lightColors = lightColors(
    primary = Color(0xff1675d1),
    primaryVariant = Color(0xff62a3ff),
    onPrimary = Color(0xffffffff),
    secondary = Color(0xff81c784),
    secondaryVariant = Color(0xffb2fab4),
    onSecondary = Color(0xff000000),
    surface = Color(0xffdddddd),
    onSurface = Color(0xff000000),
    background = Color(0xffdddddd),
    onBackground = Color(0xff000000),
    error = Color(0xffff8a65),
    onError = Color(0xff000000)
)

@Composable
fun StellarPresentationTheme(
    typography: Typography = MaterialTheme.typography,
    content: @Composable () -> Unit
) {
    DesktopMaterialTheme(
        colors = lightColors,
        typography = typography
    ) {
        content()
    }
}