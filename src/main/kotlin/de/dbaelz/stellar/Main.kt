package de.dbaelz.stellar

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import de.dbaelz.stellar.demo.createDemoPresentation
import de.dbaelz.stellar.screen.MainScreen
import de.dbaelz.stellar.screen.PresentationScreen
import de.dbaelz.stellar.theme.StellarPresentationTheme

@ExperimentalComposeUiApi
fun main() = application {
    val windowState = rememberWindowState(
        placement = WindowPlacement.Floating,
        size = WindowSize(1280.dp, 720.dp)
    )

    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "Stellar Presentation",
        // TODO: Switch with Stellar Presentation icon
        icon = painterResource("images/compose-logo.png"),
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
        var screenState by remember { mutableStateOf(Screen.MAIN) }


        StellarPresentationTheme {
            Crossfade(
                targetState = screenState,
                animationSpec = tween(
                    durationMillis = 600,
                    easing = LinearOutSlowInEasing
                )
            ) { newState ->
                when (newState) {
                    Screen.MAIN -> MainScreen { screenState = Screen.PRESENTATION }
                    Screen.PRESENTATION -> PresentationScreen(createDemoPresentation()) {
                        screenState = Screen.MAIN
                    }
                }
            }
        }
    }
}

enum class Screen {
    MAIN,
    PRESENTATION,
}