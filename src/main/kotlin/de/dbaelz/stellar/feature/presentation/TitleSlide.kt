package de.dbaelz.stellar.feature.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TitleSlide(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    divider: @Composable () -> Unit = { DefaultDivider() },
    footer: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            Box(Modifier.padding(horizontal = 8.dp, vertical = 16.dp)) {
                title()
            }

            divider()

            Box(Modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
                content()
            }
        }


        Box(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
                .height(32.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            footer()
        }
    }
}

@Composable
fun TitleSlide(
    title: String,
    modifier: Modifier = Modifier,
    divider: @Composable () -> Unit = { DefaultDivider() },
    footer: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    TitleSlide(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        modifier = modifier,
        divider = divider,
        footer = footer,
        content = content
    )
}

@Composable
private fun DefaultDivider() {
    Divider(
        color = MaterialTheme.colors.onBackground,
        thickness = 3.dp
    )
}