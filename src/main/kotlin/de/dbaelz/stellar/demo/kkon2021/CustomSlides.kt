package de.dbaelz.stellar.demo.kkon2021

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import de.dbaelz.stellar.feature.presentation.CaptionContent
import de.dbaelz.stellar.feature.presentation.ListItem
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
    leftContent: @Composable RowScope.() -> Unit,
    rightContent: @Composable RowScope.() -> Unit,
    footer: @Composable () -> Unit
) = TitleSlide(
    title = title,
    footer = footer,
    content = {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Top
        ) {
            leftContent()

            rightContent()
        }
    }
)

@Composable
fun RowScope.ImageItem(
    image: Painter,
    contentScale: ContentScale = ContentScale.Fit,
    modifier: Modifier = Modifier,
) {
    var zoomed by remember { mutableStateOf(false) }
    val weight by derivedStateOf { if (zoomed) 10_000f else 0.5f }
    val scale by derivedStateOf { if (zoomed) 1.4f else 1f }

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .weight(weight)
            .scale(scale)
            .verticalScroll(rememberScrollState(0))
            .padding(bottom = 8.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { zoomed = !zoomed }
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = modifier
                .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(16.dp))
                .padding(2.dp)
                .clip(RoundedCornerShape(16.dp)),
            painter = image,
            contentDescription = null,
            contentScale = contentScale
        )
    }
}

@Composable
fun RowScope.ContentListItems(
    modifier: Modifier = Modifier,
    weight: Float = 0.5f,
    bulletPoint: ImageVector? = Icons.Default.KeyboardArrowRight,
    itemsBackgroundColor: Color = MaterialTheme.colors.secondary.copy(alpha = 0.8f),
    itemsContentColor: Color = MaterialTheme.colors.onSecondary,
    itemsArrangement: Arrangement.Vertical = Arrangement.Top,
    items: List<String>
) {
    Column(
        modifier = modifier.fillMaxHeight().weight(weight),
        verticalArrangement = itemsArrangement
    ) {
        items.forEach { text ->
            ListItem(text, bulletPoint, true, itemsBackgroundColor, itemsContentColor)

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}