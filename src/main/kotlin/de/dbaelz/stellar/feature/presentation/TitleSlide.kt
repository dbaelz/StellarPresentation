package de.dbaelz.stellar.feature.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TitleSlide(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    divider: @Composable () -> Unit = {},
    footer: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            Box(Modifier.padding(horizontal = 64.dp, vertical = 48.dp)) {
                title()
            }

            divider()

            Box(Modifier.padding(horizontal = 96.dp, vertical = 16.dp)) {
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
    titleBackgroundColor: Color = MaterialTheme.colors.primary.copy(alpha = 0.8f),
    titleContentColor: Color = MaterialTheme.colors.onPrimary,
    modifier: Modifier = Modifier,
    divider: @Composable () -> Unit = {},
    footer: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    TitleSlide(
        title = {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = titleBackgroundColor,
                contentColor = titleContentColor,
                modifier = Modifier.wrapContentSize()
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h2,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(16.dp)
                )
            }
        },
        modifier = modifier,
        divider = divider,
        footer = footer,
        content = content
    )
}