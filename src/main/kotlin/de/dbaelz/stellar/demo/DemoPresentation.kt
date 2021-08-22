package de.dbaelz.stellar.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
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
            backgroundImage = painterResource("images/compose-logo.png")
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

    return Presentation(slides)
}

@Composable
private fun Footer(textLeft: String, slideNumber: Int, maxSlides: Int) {
    Row(
        Modifier.fillMaxSize().alpha(0.4f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(textLeft)
        Text("$slideNumber/$maxSlides")
    }
}
