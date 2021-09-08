package de.dbaelz.stellar.feature.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale

@Composable
fun ImageSlide(
    title: String,
    image: Painter,
    contentScale: ContentScale = ContentScale.Fit,
    modifier: Modifier = Modifier,
    footer: @Composable () -> Unit = {}
) {
    TitleSlide(
        title = title,
        modifier = Modifier,
        footer = footer
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = modifier,
                painter = image,
                contentDescription = null,
                contentScale = contentScale
            )
        }

    }
}