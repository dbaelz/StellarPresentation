package de.dbaelz.stellar.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

val MarkaziText = FontFamily(
    Font(
        resource = "fonts/markazitext/MarkaziText.ttf",
        weight = FontWeight.Bold,
        style = FontStyle.Normal
    ),
    Font(
        resource = "fonts/markazitext/MarkaziText.ttf",
        weight = FontWeight.Medium,
        style = FontStyle.Normal
    ),
    Font(
        resource = "fonts/markazitext/MarkaziText.ttf",
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    ),
    Font(
        resource = "fonts/markazitext/MarkaziText.ttf",
        weight = FontWeight.SemiBold,
        style = FontStyle.Normal
    ),
)

val MarkaziTextTypography = Typography(defaultFontFamily = MarkaziText)