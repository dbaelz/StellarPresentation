package de.dbaelz.stellar.demo.kkon2021.example

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun CounterButton() {
    var counter by remember { mutableStateOf(0) }

    Button(onClick = { counter++ }) {
        Text("Counter: $counter")
    }
}

@ExperimentalComposeUiApi
@Composable
fun DialogWindowExample() {
    var showDialog by remember { mutableStateOf(false) }

    Button(onClick = { showDialog = true }) {
        Text("Open Dialog", style = MaterialTheme.typography.h3)
    }

    if (showDialog) {
        DialogWindow { showDialog = false }
    }
}

@ExperimentalComposeUiApi
@Composable
private fun DialogWindow(onClickAndDismiss: () -> Unit) {
    Dialog(
        title = "Dialog Window Example",
        onCloseRequest = {
            onClickAndDismiss()
        }
    ) {
        Text(
            text = "This is a dialog window",
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
    }
}
