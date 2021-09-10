package de.dbaelz.stellar.demo.kkon2021.example

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import javax.swing.JButton


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


@Composable
fun SwingPanelExample() {
    var counter by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SwingPanel(
            background = MaterialTheme.colors.background,
            modifier = Modifier.width(400.dp).height(50.dp),
            factory = {
                return@SwingPanel JButton("Increase counter").apply {
                    addActionListener { counter++ }
                }
            }
        )

        Spacer(Modifier.height(8.dp))

        Text("Counter: $counter")
    }
}
