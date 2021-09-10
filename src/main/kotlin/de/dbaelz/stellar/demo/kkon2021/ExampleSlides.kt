package de.dbaelz.stellar.demo.kkon2021

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import de.dbaelz.stellar.demo.kkon2021.example.CounterButton
import de.dbaelz.stellar.demo.kkon2021.example.DialogWindowExample
import de.dbaelz.stellar.demo.kkon2021.example.SwingPanelExample
import de.dbaelz.stellar.feature.presentation.ListSlide


@Composable
internal fun ComposeForDesktopExampleCounterButton() = LeftRightSlide(
    title = "Compose for Desktop: Beispiel",
    footer = { Footer() },
    leftContent = {
        Box(
            modifier = Modifier.weight(0.5f).fillMaxHeight().scale(2.5f),
            contentAlignment = Alignment.Center
        ) {
            CounterButton()
        }
    },
    rightContent = {
        ImageItem(image = painterResource("$PRESENTATION_RESOURCE_DIR/example/counter-button.png"))
    }
)


@Composable
internal fun DesktopAPIs() = ListSlide(
    title = "Desktop APIs",
    footer = { Footer() },
    items = listOf(
        "Window",
        "Maus und Tastatur",
        "Menubar",
        "Scrollbars",
        "Tooltip",
        "Swing Interoperabilität",
        "...und viele mehr"
    )
)


@ExperimentalComposeUiApi
@Composable
internal fun ComposeForDesktopExampleWindow() = LeftRightSlide(
    title = "Window API",
    footer = { Footer() },
    leftContent = {
        Box(
            modifier = Modifier.weight(0.5f).fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            DialogWindowExample()
        }
    },
    rightContent = {
        ImageItem(image = painterResource("$PRESENTATION_RESOURCE_DIR/example/dialog-window.png"))
    }
)

@Composable
internal fun ComposeForDesktopExampleInteropSwing() = LeftRightSlide(
    title = "Swing Interoperabilität",
    footer = { Footer() },
    leftContent = {
        Box(
            modifier = Modifier.weight(0.5f).fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            SwingPanelExample()
        }
    },
    rightContent = {
        ImageItem(image = painterResource("$PRESENTATION_RESOURCE_DIR/example/swing-panel.png"))
    }
)