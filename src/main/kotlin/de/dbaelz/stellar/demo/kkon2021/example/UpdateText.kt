package de.dbaelz.stellar.demo.kkon2021.example

import androidx.compose.foundation.border
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


class ImperativeText {


    fun updateText(counter: Int) {
        setText(counter.toString())

        when (counter) {
            0 -> {
                setTextColor(Color.Black)
                setBorder(2.dp, Color.Black)
            }
            in 1..5 -> {
                setTextColor(Color.Green)
                removeBorder()
            }
            in 6..10 -> {
                setTextColor(Color.Red)
                removeBorder()
            }
            else -> {
                setTextColor(Color.Red)
                setBorder(2.dp, Color.Red)
            }
        }
    }


    private fun setText(text: String) {

    }

    private fun setTextColor(color: Color) {

    }

    private fun setBorder(width: Dp, color: Color) {

    }

    private fun removeBorder() {

    }
}

fun callImperativeText() {
    ImperativeText().updateText(11)
}

@Composable
fun DeclarativeText(counter: Int) {


    Text(
        text = counter.toString(),
        color = when (counter) {
            0 -> Color.Black
            in 1..5 -> Color.Green
            else -> Color.Red
        },
        modifier = when {
            counter == 0 -> Modifier.border(2.dp, Color.Black)
            counter >= 11 -> Modifier.border(2.dp, Color.Red)
            else -> Modifier
        }
    )

}


