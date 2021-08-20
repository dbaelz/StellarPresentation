package de.dbaelz.stellar

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import de.dbaelz.stellar.theme.StellarPresentationTheme

@ExperimentalComposeUiApi
fun main() = application {
    val windowState = rememberWindowState(
        placement = WindowPlacement.Floating,
        size = WindowSize(1024.dp, 768.dp)
    )

    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "Stellar Presentation",
        resizable = true,
        onKeyEvent = {
            when {
                it.key == Key.F11 -> {
                    // Ignore key up (release) and only react when the key is pressed
                    if (it.type == KeyEventType.KeyUp) return@Window false

                    // Known issue: Fullscreen always switches to Floating even
                    // if previously it was Maximized
                    if (windowState.placement == WindowPlacement.Fullscreen) {
                        windowState.placement = WindowPlacement.Floating
                    } else {
                        windowState.placement = WindowPlacement.Fullscreen
                    }
                    true
                }
                else -> false
            }
        }
    ) {
        StellarPresentationTheme {

        }
    }
}