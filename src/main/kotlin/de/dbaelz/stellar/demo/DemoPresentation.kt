package de.dbaelz.stellar.demo

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.dbaelz.stellar.feature.presentation.Presentation
import de.dbaelz.stellar.feature.presentation.TitleSlide

// TODO: Move this into a Gradle module for better separation
//  of Stellar and the actual presentations
@Composable
fun createDemoPresentation(): Presentation {
    val slides = mutableListOf<@Composable () -> Unit>()

    slides.add {
        TitleSlide(
            title = "Compose for Desktop",
            subtitle = "Build beautiful desktop apps easily",
            backgroundImage = painterResource("images/compose-logo.png")
        )
    }

    (1..10).forEach {
        slides.add { DemoSlide(it) }
    }

    return Presentation(slides)
}

@Composable
private fun Footer(title: String, slideNumber: Int, maxSlides: Int) {
    Row(
        Modifier.fillMaxSize().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(title)
        Text("$slideNumber/$maxSlides")
    }
}

@Composable
private fun DemoSlide(index: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Slide $index",
            style = MaterialTheme.typography.h1
        )
    }
}