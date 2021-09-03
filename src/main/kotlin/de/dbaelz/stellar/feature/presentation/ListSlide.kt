package de.dbaelz.stellar.feature.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ListSlide(
    title: String,
    modifier: Modifier = Modifier,
    footer: @Composable () -> Unit = {},
    itemsArrangement: Arrangement.Vertical = Arrangement.Top,
    items: List<@Composable ColumnScope.() -> Unit>
) {
    TitleSlide(
        title = title,
        modifier = modifier,
        footer = footer
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = itemsArrangement
        ) {
            items.forEach { composable ->
                composable()

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ListSlide(
    title: String,
    modifier: Modifier = Modifier,
    footer: @Composable () -> Unit = {},
    bulletPoint: ImageVector? = Icons.Default.KeyboardArrowRight,
    items: List<String>,
    itemsBackgroundColor: Color = MaterialTheme.colors.secondary.copy(alpha = 0.8f),
    itemsContentColor: Color = MaterialTheme.colors.onSecondary,
) {
    val composableItems = mutableListOf<@Composable ColumnScope.() -> Unit>()
    items.forEach { text ->
        composableItems.add {
            ListItem(text, bulletPoint, itemsBackgroundColor, itemsContentColor)
        }
    }

    ListSlide(
        title = title,
        modifier = modifier,
        footer = footer,
        itemsArrangement = Arrangement.SpaceEvenly,
        items = composableItems
    )
}

@Composable
fun ListItem(
    text: String,
    bulletPoint: ImageVector?,
    itemsBackgroundColor: Color,
    itemsContentColor: Color
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = itemsBackgroundColor,
        contentColor = itemsContentColor,
        modifier = Modifier.wrapContentSize()
    ) {

        Row(Modifier.wrapContentSize().padding(8.dp)) {
            if (bulletPoint != null) {
                Icon(
                    imageVector = bulletPoint,
                    contentDescription = null,
                    tint = itemsContentColor,
                    modifier = Modifier.size(40.dp).align(Alignment.CenterVertically)
                )
            }

            Text(
                text = text,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Start
            )
        }
    }
}