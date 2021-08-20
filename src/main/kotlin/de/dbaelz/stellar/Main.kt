package de.dbaelz.stellar

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import de.dbaelz.stellar.theme.StellarPresentationTheme

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(
            placement = WindowPlacement.Floating,
            size = WindowSize(1024.dp, 768.dp)
        ),
        title = "Stellar Presentation",
        resizable = true
    ) {
        StellarPresentationTheme {

        }
    }
}