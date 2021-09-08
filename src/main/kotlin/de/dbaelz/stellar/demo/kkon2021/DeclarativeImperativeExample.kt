package de.dbaelz.stellar.demo.kkon2021

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DeclarativeImperativeExample(modifier: Modifier = Modifier) {
    val counterModifier = Modifier.size(86.dp)
    Row(
        modifier = modifier
    ) {
        (0..11).forEach {
            BorderBox {
                Counter(counterModifier, it)
            }
        }
    }
}

@Composable
private fun BorderBox(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .border(2.dp, Color.Gray, RoundedCornerShape(16.dp))
            .padding(8.dp)
            .wrapContentSize()
    ) {
        content()
    }
}

@Composable
private fun Counter(modifier: Modifier, counter: Int) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = when {
            counter == 0 -> modifier.border(4.dp, Color.Black, CircleShape)
            counter > 10 -> modifier.border(4.dp, Color.Red, CircleShape)
            else -> modifier
        },
    ) {
        Text(
            text = counter.toString(),
            color = when (counter) {
                0 -> Color.Black
                in 1..5 -> Color.DarkGreen
                else -> Color.Red
            },
            textAlign = TextAlign.Center,
            fontSize = 44.sp
        )
    }

}

private val Color.Companion. DarkGreen: Color
    get() = Color(0xFF00CF00)