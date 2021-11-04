package de.dbaelz.stellar

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.application
import de.dbaelz.stellar.demo.createDemoPresentation
import de.dbaelz.stellar.screen.StellarPresentationWindow

fun main() = application {
    val presentations = listOf(
        createDemoPresentation(),
        createDemoPresentation(),
        createDemoPresentation()
    )

    StellarPresentationWindow(1280.dp, 720.dp, presentations, ::exitApplication)
}
