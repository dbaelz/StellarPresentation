package de.dbaelz.stellar.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

private val Lato = FontFamily(
    Font(
        resource = "fonts/lato/Lato-Black.ttf",
        weight = FontWeight.Black,
        style = FontStyle.Normal
    ),
    Font(
        resource = "fonts/lato/Lato-BlackItalic.ttf",
        weight = FontWeight.Black,
        style = FontStyle.Italic
    ),
    Font(
        resource = "fonts/lato/Lato-Bold.ttf",
        weight = FontWeight.Bold,
        style = FontStyle.Normal
    ),
    Font(
        resource = "fonts/lato/Lato-BoldItalic.ttf",
        weight = FontWeight.Bold,
        style = FontStyle.Italic
    ),

    Font(
        resource = "fonts/lato/Lato-Italic.ttf",
        weight = FontWeight.Normal,
        style = FontStyle.Italic
    ),
    Font(
        resource = "fonts/lato/Lato-Light.ttf",
        weight = FontWeight.Light,
        style = FontStyle.Normal
    ),
    Font(
        resource = "fonts/lato/Lato-LightItalic.ttf",
        weight = FontWeight.Light,
        style = FontStyle.Italic
    ),
    Font(
        resource = "fonts/lato/Lato-Regular.ttf",
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    ),
    Font(
        resource = "fonts/lato/Lato-Thin.ttf",
        weight = FontWeight.Thin,
        style = FontStyle.Normal
    ),
    Font(
        resource = "fonts/lato/Lato-ThinItalic.ttf",
        weight = FontWeight.Thin,
        style = FontStyle.Italic
    )
)

val LatoTypography = Typography(defaultFontFamily = Lato)