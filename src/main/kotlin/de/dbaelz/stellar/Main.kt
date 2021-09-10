package de.dbaelz.stellar

import androidx.compose.foundation.ExperimentalDesktopApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.application
import de.dbaelz.stellar.demo.createDemoPresentation
import de.dbaelz.stellar.demo.kkon2021.createComposeForDesktopPresentation
import de.dbaelz.stellar.screen.StellarPresentationWindow

@ExperimentalDesktopApi
@ExperimentalComposeUiApi
fun main() = application {
    val presentations = listOf(
        createComposeForDesktopPresentation(),
        createDemoPresentation(),
        createDemoPresentation()
    )

    StellarPresentationWindow(1280.dp, 720.dp, presentations, ::exitApplication)
}
