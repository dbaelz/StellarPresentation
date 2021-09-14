package de.dbaelz.stellar.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.dbaelz.stellar.feature.presentation.CaptionSlide
import de.dbaelz.stellar.feature.presentation.ImageSlide
import de.dbaelz.stellar.feature.presentation.ListSlide
import de.dbaelz.stellar.feature.presentation.Presentation
import de.dbaelz.stellar.theme.IndieFlowerTypography

@Composable
fun createDemoPresentation(): Presentation {
    return Presentation(
        title = "Sample Presentation",
        description = "A simple presentation that showcases Stellar Presentation",
        typography = IndieFlowerTypography,
        slides = listOf(
            {
                CaptionSlide(
                    title = "Stellar Presentation",
                    subtitle = "A presentation application build with Compose for Desktop",
                    background = {
                        Image(
                            painter = painterResource("images/compose-desktop-logo.png"),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize().alpha(0.4f)
                        )
                    })
            },
            {
                ListSlide(
                    title = "About Stellar Presentation...",
                    footer = { Footer(2) },
                    items = listOf(
                        "Demo app for Compose for Desktop",
                        "Every slide is a Composable",
                        "Provides common layouts for slides",
                        "Support for presentation specific typography",
                        "Navigation with the arrow keys",
                    )
                )
            },
            {
                ImageSlide(
                    title = "...and a slide with an image",
                    image = painterResource("images/compose-desktop-logo.png"),
                    footer = { Footer(3) },
                )
            },
            {
                ImageSlide(
                    title = "...and another slide with an image and modifier",
                    image = painterResource("images/compose-logo.png"),
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .fillMaxHeight(0.8f)
                        .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(16.dp))
                        .padding(2.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    footer = { Footer(3) },
                )
            },
        )
    )
}

@Composable
private fun Footer(slideNumber: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CompositionLocalProvider(
                LocalTextStyle provides TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 16.sp
                )
            ) {
                Text("Compose for Desktop")
                Text(slideNumber.toString())
            }
        }

        Spacer(Modifier.height(4.dp))

        Divider(thickness = 12.dp, color = MaterialTheme.colors.primary)
    }

}
