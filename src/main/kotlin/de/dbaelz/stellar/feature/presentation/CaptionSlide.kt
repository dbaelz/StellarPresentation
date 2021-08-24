package de.dbaelz.stellar.feature.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    background: @Composable () -> Unit = {},
    footer: @Composable () -> Unit = {}
) {
    CaptionSlide(modifier, footer) {
        background()

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
}