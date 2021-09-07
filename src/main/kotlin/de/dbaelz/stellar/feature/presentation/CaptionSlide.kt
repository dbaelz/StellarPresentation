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
import androidx.compose.ui.unit.sp

@Composable
fun CaptionSlide(
    modifier: Modifier = Modifier,
    footer: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        content()

        Box(Modifier.fillMaxWidth().height(32.dp).align(Alignment.BottomCenter)) {
            footer()
        }
    }
}

@Composable
fun CaptionSlide(
    title: String,
    subtitle: String? = null,
    backgroundColor: Color = MaterialTheme.colors.primary.copy(alpha = 0.8f),
    contentColor: Color = MaterialTheme.colors.onPrimary,
    contentModifier: Modifier = Modifier,
    background: @Composable () -> Unit = {},
    footer: @Composable () -> Unit = {}
) {
    CaptionSlide(footer = footer) {
        background()

        CaptionContent(title, subtitle, backgroundColor, contentColor, contentModifier)
    }
}

@Composable
fun CaptionContent(
    title: String,
    subtitle: String? = null,
    backgroundColor: Color = MaterialTheme.colors.primary.copy(alpha = 0.8f),
    contentColor: Color = MaterialTheme.colors.onPrimary,
    contentModifier: Modifier = Modifier,
) {
    Surface(
        shape = RoundedCornerShape(32.dp),
        color = backgroundColor,
        contentColor = contentColor,
        modifier = contentModifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = title,
                fontSize = 128.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )

            if (subtitle != null) {
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}