package de.dbaelz.stellar.feature.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun ImageSlide(
    title: String,
    image: Painter,
    modifier: Modifier = Modifier,
    footer: @Composable () -> Unit = {}
) {
    TitleSlide(
        title = title,
        modifier = modifier,
        footer = footer
    ) {
        Image(
            modifier = modifier.fillMaxSize(),
            painter = image,
            contentDescription = null,
        )
    }
}