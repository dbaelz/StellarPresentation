package de.dbaelz.stellar.feature.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ListSlide(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    footer: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(Modifier.fillMaxSize()) {
            title()

            // TODO: Divider as Composable parameter?
            Divider(color = MaterialTheme.colors.primary)

            content()
        }


        Box(Modifier.fillMaxWidth().height(32.dp).align(Alignment.BottomCenter)) {
            footer()
        }
    }
}

@Composable
fun ListSlide(
    title: String,
    modifier: Modifier = Modifier,
    footer: @Composable () -> Unit = {},
    items: List<@Composable ColumnScope.() -> Unit>
) {
    ListSlide(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        modifier = modifier,
        footer = footer
    ) {
        Column {
            items.forEach { composable ->
                composable()

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@JvmName("ListSlideTexts")
@Composable
fun ListSlide(
    title: String,
    modifier: Modifier = Modifier,
    footer: @Composable () -> Unit = {},
    texts: List<String>
) {
    val items = mutableListOf<@Composable ColumnScope.() -> Unit>()
    texts.forEach {
        items.add {
            Row(Modifier.fillMaxWidth().wrapContentHeight()) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.wrapContentHeight().align(Alignment.CenterVertically)
                )

                Spacer(Modifier.width(8.dp))

                Text(
                    text = it,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground,
                    textAlign = TextAlign.Start
                )
            }
        }
    }

    ListSlide(
        title = title,
        modifier = modifier,
        footer = footer,
        items = items
    )
}