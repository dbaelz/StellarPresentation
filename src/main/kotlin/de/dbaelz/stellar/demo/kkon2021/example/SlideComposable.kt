package de.dbaelz.stellar.demo.kkon2021.example

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*


@Composable
fun CounterButton() {
    var counter by remember { mutableStateOf(0) }

    Button(onClick = { counter++ }) {
        Text("Counter: $counter")
    }
}