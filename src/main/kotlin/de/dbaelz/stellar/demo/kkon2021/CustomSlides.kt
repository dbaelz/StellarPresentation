package de.dbaelz.stellar.demo.kkon2021

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.dbaelz.stellar.feature.presentation.CaptionContent
import de.dbaelz.stellar.feature.presentation.TitleSlide


@Composable
fun CustomTitleSlide(
    title: String,
    captionTitle: String,
    captionSubtitle: String,
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
                contentModifier = Modifier.border(2.dp, Color.Gray, RoundedCornerShape(32.dp)),
            )
        }
    }
)