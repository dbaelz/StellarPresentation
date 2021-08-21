package de.dbaelz.stellar.screen

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.*

@ExperimentalComposeUiApi
@Composable
fun PresentationScreen(onBackNavigation: () -> Unit) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Box(Modifier
        .fillMaxSize()
        .focusRequester(focusRequester)
        .onPreviewKeyEvent {
            // Ignore key up (release) and only react when the key is pressed
            if (it.type == KeyEventType.KeyUp) return@onPreviewKeyEvent false

            when (it.key) {
                Key.Escape -> {
                    onBackNavigation()
                    return@onPreviewKeyEvent true
                }
                else -> false
            }
        }
        .focusable())
    {
        Text(text = "Presentation Screen", style = MaterialTheme.typography.h1)
    }
}