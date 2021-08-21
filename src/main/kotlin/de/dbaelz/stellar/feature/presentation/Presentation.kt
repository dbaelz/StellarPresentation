package de.dbaelz.stellar.feature.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class Presentation(private val slides: List<@Composable () -> Unit>) {
    private var currentIndex by mutableStateOf(0)

    val currentSlide by derivedStateOf {
        slides[currentIndex]
    }

    fun nextSlide() {
        currentIndex = (currentIndex + 1).coerceAtMost(slides.size - 1)
    }

    fun previousSlide() {
        currentIndex = (currentIndex - 1).coerceAtLeast(0)
    }
}

@Composable
fun createDemoPresentation(): Presentation {
    val slides = mutableListOf<@Composable () -> Unit>()
    (1..10).forEach {
        slides.add { DemoSlide(it) }
    }

    return Presentation(slides)
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