package de.dbaelz.stellar.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

private val Caveat = FontFamily(
    Font(
        resource = "fonts/caveat/Caveat-Bold.ttf",
        weight = FontWeight.Bold,
        style = FontStyle.Normal
    ),
    Font(
        resource = "fonts/caveat/Caveat-Medium.ttf",
        weight = FontWeight.Medium,
        style = FontStyle.Normal
    ),
    Font(
        resource = "fonts/caveat/Caveat-Regular.ttf",
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    ),
    Font(
        resource = "fonts/caveat/Caveat-SemiBold.ttf",
        weight = FontWeight.SemiBold,
        style = FontStyle.Normal
    ),
)

val CaveatTypography = Typography(defaultFontFamily = Caveat)