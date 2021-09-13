package de.dbaelz.stellar.demo.kkon2021.example

import androidx.compose.foundation.ExperimentalDesktopApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.mouseClickable
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.input.pointer.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import javax.swing.JButton


@Composable
fun CounterButton() {
    var counter by remember { mutableStateOf(0) }

    Button(onClick = { counter++ }) {
        Text("Counter: $counter")
    }
}

@Composable
fun IconTextCounterButton() {
    var counter by remember { mutableStateOf(0) }

    CustomButton(modifier = Modifier.size(150.dp), onClick = { counter++ }) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.AddCircle, null, Modifier.size(48.dp))

            Spacer(Modifier.width(16.dp))

            Text(
                text = "$counter", fontSize = 40.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(onClick = onClick, modifier = modifier) {
        content()
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


@ExperimentalDesktopApi
@Composable
fun MouseClickableExample() {
    var mouseButtonText by remember { mutableStateOf("") }
    var keyboardModifierText by remember { mutableStateOf("") }
    val text by derivedStateOf {
        "Button: $mouseButtonText \nKeyboard Modifier: $keyboardModifierText"
    }

    Text(
        text = text,
        style = MaterialTheme.typography.h4,
        modifier = Modifier.mouseClickable {
            mouseButtonText = when {
                buttons.isPrimaryPressed -> "Primary"
                buttons.isSecondaryPressed -> "Secondary"
                buttons.isTertiaryPressed -> "Tertiary"
                else -> ""
            }
            keyboardModifierText = when {
                keyboardModifiers.isShiftPressed -> "SHIFT"
                keyboardModifiers.isAltPressed -> "ALT"
                keyboardModifiers.isCtrlPressed -> "CTRL"
                else -> ""
            }
        }
    )
}
