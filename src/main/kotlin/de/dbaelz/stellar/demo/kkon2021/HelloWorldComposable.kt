package de.dbaelz.stellar.demo.kkon2021

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun HelloWorldComposable() {
    Dialog(
        title = "Hello World Compose",
        onCloseRequest = {}
    ) {
        Text(
            text = "Hello World",
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(16.dp)
        )
    }
}