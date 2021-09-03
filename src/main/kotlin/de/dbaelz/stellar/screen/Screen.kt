package de.dbaelz.stellar.screen


sealed class Screen {
    object Main : Screen()
    class Presentation(
        val presentation: de.dbaelz.stellar.feature.presentation.Presentation
    ) : Screen()
}