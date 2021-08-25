package de.dbaelz.stellar.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.dbaelz.stellar.feature.presentation.CaptionSlide
import de.dbaelz.stellar.feature.presentation.ImageSlide
import de.dbaelz.stellar.feature.presentation.ListSlide
import de.dbaelz.stellar.feature.presentation.Presentation

// TODO: Move this into a Gradle module for better separation
//  of Stellar and the actual presentations
@Composable
fun createDemoPresentation(): Presentation {
    val maxSlides = 3

    val slides = mutableListOf<@Composable () -> Unit>()

    slides.add {
        CaptionSlide(
            title = "Compose for Desktop",
            subtitle = "Build beautiful desktop apps easily",
            background = {
                Image(
                    painter = painterResource("images/compose-logo.png"),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize().alpha(0.4f)
                )
            }
        )
    }

    slides.add {
        ListSlide(
            title = "About Compose for Desktop",
            footer = { Footer("Compose for Desktop", 2, maxSlides) },
            items = listOf(
                "Declarative UI for Desktop",
                "Developed by JetBrains",
                "Origin: Jetpack Compose (Android)",
            )
        )
    }

    slides.add {
        ImageSlide(
            title = "...and a slide with an image",
            image = painterResource("images/compose-logo.png"),
            footer = { Footer("Compose for Desktop", 3, maxSlides) },
        )
    }

    return Presentation("A simple demo presentation", slides)
}

@Composable
private fun Footer(textLeft: String, slideNumber: Int, maxSlides: Int) {
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
                Text(textLeft)
                Text("$slideNumber/$maxSlides")
            }

        }

        Spacer(Modifier.height(4.dp))

        Divider(thickness = 12.dp, color = MaterialTheme.colors.primary)
    }

}
