package de.dbaelz.stellar.feature.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TitleSlide(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    divider: @Composable () -> Unit = {
        Divider(
            color = MaterialTheme.colors.primary,
            thickness = 2.dp
        )
    },
    footer: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            Box(Modifier.padding(horizontal = 4.dp, vertical = 8.dp)) {
                title()
            }

            divider()

            Box(Modifier.padding(horizontal = 4.dp, vertical = 8.dp)) {
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