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
import de.dbaelz.stellar.theme.LatoTypography
import de.dbaelz.stellar.theme.StellarPresentationTheme

@ExperimentalComposeUiApi
fun main() = application {
    val defaultWindowSize = WindowSize(1280.dp, 720.dp)
    val windowState = rememberWindowState(
        placement = WindowPlacement.Floating,
        size = defaultWindowSize
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
                        windowState.size = defaultWindowSize
                    } else {
                        windowState.placement = WindowPlacement.Fullscreen
                    }
                    true
                }
                it.key == Key.F12 -> {
                    if (it.type == KeyEventType.KeyUp) return@Window false
                    windowState.placement = WindowPlacement.Floating
                    windowState.size = defaultWindowSize

                    true
                }
                else -> false
            }
        }
    ) {
        var screen: Screen by remember { mutableStateOf(Screen.Main) }

        // Workaround because we can't use LocalTypography to change the typography
        // for components/screens of the app.
        // Change it for the presentation and reset it for MAIN
        var typography by remember { mutableStateOf(LatoTypography) }

        val presentations = listOf(createDemoPresentation())

        StellarPresentationTheme(
            typography = typography
        ) {
            Crossfade(
                targetState = screen,
                animationSpec = tween(
                    durationMillis = 600,
                    easing = LinearOutSlowInEasing
                )
            ) { newScreen ->
                when (newScreen) {
                    is Screen.Main -> {
                        typography = LatoTypography
                        MainScreen(presentations) {
                            screen = Screen.Presentation(it)
                        }
                    }
                    is Screen.Presentation -> {
                        typography = newScreen.presentation.typography
                        PresentationScreen(newScreen.presentation) {
                            screen = Screen.Main
                        }
                    }
                }
            }
        }
    }
}

sealed class Screen {
    object Main : Screen()
    class Presentation(
        val presentation: de.dbaelz.stellar.feature.presentation.Presentation
    ) : Screen()
}