package de.dbaelz.stellar.feature.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    backgroundImage: Painter? = null,
    footer: @Composable () -> Unit = {}
) {
    CaptionSlide(modifier, footer) {
        if (backgroundImage != null) Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier.alpha(0.4f)
        )

        Surface(
            shape = RoundedCornerShape(32.dp),
            color = MaterialTheme.colors.primary.copy(alpha = 0.8f),
            contentColor = MaterialTheme.colors.onPrimary,
            modifier = Modifier.wrapContentSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(32.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h1,
                    fontWeight = FontWeight.Bold,
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
}