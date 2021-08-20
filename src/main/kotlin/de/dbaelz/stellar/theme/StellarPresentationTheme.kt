package de.dbaelz.stellar.theme

import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun StellarPresentationTheme(
    content: @Composable () -> Unit
) {
    DesktopMaterialTheme {
        content()
    }
}