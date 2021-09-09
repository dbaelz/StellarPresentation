package de.dbaelz.stellar.demo.kkon2021

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import de.dbaelz.stellar.feature.presentation.CaptionContent
import de.dbaelz.stellar.feature.presentation.TitleSlide


@Composable
fun KeySentenceSlide(
    title: String,
    captionTitle: String,
    captionSubtitle: String = "",
    footer: @Composable () -> Unit
) = TitleSlide(
    title = title,
    footer = footer,
    content = {
        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f),
            contentAlignment = Alignment.Center
        ) {
            CaptionContent(
                title = captionTitle,
                subtitle = captionSubtitle,
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.onSecondary,
                contentModifier = Modifier.border(4.dp, Color.Gray, RoundedCornerShape(32.dp)),
            )
        }
    }
)

@Composable
fun LeftRightSlide(
    title: String,
    leftContent: @Composable () -> Unit,
    rightContent: @Composable () -> Unit,
    footer: @Composable () -> Unit
) = TitleSlide(
    title = title,
    footer = footer,
    content = {
        Row(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f),
        ) {
            leftContent()

            rightContent()
        }
    }
)

@Composable
fun RowScope.CodeImage(
    image: Painter,
    contentScale: ContentScale = ContentScale.Fit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier.weight(0.5f),
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

@Composable
fun RowScope.CodeContent(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.weight(0.5f),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}