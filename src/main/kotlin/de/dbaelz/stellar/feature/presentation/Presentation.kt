package de.dbaelz.stellar.feature.presentation

import androidx.compose.runtime.*

class Presentation(
    val description: String = "",
    private val slides: List<@Composable () -> Unit>
) {
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

    fun firstSlide() {
        currentIndex = 0
    }

    fun lastSlide() {
        currentIndex = slides.size - 1
    }
}
