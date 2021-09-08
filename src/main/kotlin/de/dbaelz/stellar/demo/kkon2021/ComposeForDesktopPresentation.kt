package de.dbaelz.stellar.demo.kkon2021

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import de.dbaelz.stellar.feature.presentation.*
import de.dbaelz.stellar.theme.LatoTypography

private const val PRESENTATION_RESOURCE_DIR = "presentation/kkon2021"

@Composable
fun createComposeForDesktopPresentation(): Presentation {
    return Presentation(
        title = "Compose for Desktop",
        description = "KKON 2021: Compose for Desktop",
        typography = LatoTypography,
        slides = listOf(
            { Caption() },

            { About() },

            { DeclarativeImperativeCaption() },
            { DeclarativeImperativeStory() },
            { DeclarativeImperativeImage() },

            { ImperativeFunctionCode() },
            { ImperativeDefinition() },

            { DeclarativeCode() },
            { DeclarativeDefinition() },


            { Demo() },

            { Ecosystem() },
            { Conclusion() },
            { Resources() },
            { Questions() },
        )
    )
}


@Composable
private fun Caption() {
    CaptionSlide(
        title = "Compose for Desktop",
        //subtitle = "",
        contentModifier = Modifier.fillMaxWidth(0.8f),
        background = {
            Image(
                painter = painterResource("images/compose-logo.png"),
                contentDescription = null,
                modifier = Modifier.fillMaxSize().alpha(0.4f)
            )
        })
}

@Composable
private fun About() = AboutSlide(
    name = "Daniel Bälz",
    designation = "Android-Entwickler @ inovex",
    info = {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource("$PRESENTATION_RESOURCE_DIR/avatar.png"),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .border(4.dp, Color.LightGray, RoundedCornerShape(16.dp))
                    .padding(2.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.8f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val infoModifier = Modifier
                    .padding(16.dp)
                    .width(350.dp)
                    .height(200.dp)
                    .border(
                        4.dp,
                        Color.LightGray,
                        RoundedCornerShape(12.dp)
                    )

                Column(
                    modifier = infoModifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Twitter/GitHub/Dev.to",
                        style = MaterialTheme.typography.h5
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "@dbaelz",
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.primary
                    )
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = infoModifier
                ) {

                    Text(
                        text = "https://dbaelz.de",
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.primary,
                        textAlign = TextAlign.Center,
                    )
                }
            }


        }
    },
    statement = "Mag Kaffee aus Java, programmiert jedoch lieber in Kotlin.",
    footer = { Footer() },
)

@Composable
private fun DeclarativeImperativeCaption() = CaptionSlide(
    title = "Deklarative und Imperative UI",
    contentModifier = Modifier.fillMaxWidth(0.6f),
    background = {
        Image(
            painter = painterResource("$PRESENTATION_RESOURCE_DIR/helloworld-background.png"),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
)


// TODO: Better readable list/styling? (with a box?)
@Composable
private fun DeclarativeImperativeStory() = ListSlide(
    title = "Beispiel: Eine Zahl soll formatiert angezeigt werden",
    bulletPoint = null,
    footer = { Footer() },
    items = listOf(
        "Wenn 0: Schrift in Schwarz, Rahmen in Schwarz",
        "Wenn 1..5: Schrift in Grün, kein Rahmen",
        "Wenn 6..10: Schrift in Rot, kein Rahmen",
        "Wenn > 10: Schrift in Rot, Rahmen in Rot",
    )
)

@Composable
private fun DeclarativeImperativeImage() = TitleSlide(
    title = "Beispiel: Eine Zahl soll formatiert angezeigt werden",
    footer = { Footer() },
    content = {
        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f),
            contentAlignment = Alignment.Center
        ) {
            DeclarativeImperativeExample(Modifier.padding(8.dp))
        }
    }
)


@Composable
private fun ImperativeFunctionCode() = ImageSlide(
    title = "Beispiel: Imperative UI",
    image = painterResource("$PRESENTATION_RESOURCE_DIR/imperative-function-code.png"),
    modifier = Modifier.fillMaxHeight(0.95f),
    footer = { Footer() },
)

@Composable
private fun ImperativeDefinition() = TitleSlide(
    title = "Imperative UI",
    footer = { Footer() },
    content = {
        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f),
            contentAlignment = Alignment.Center
        ) {
            CaptionContent(
                title = "Fokus auf das WIE",
                subtitle = "Wie muss sich die UI verändern"
            )
        }
    }
)


@Composable
private fun DeclarativeCode() = ImageSlide(
    title = "Beispiel: Deklarative UI",
    image = painterResource("$PRESENTATION_RESOURCE_DIR/declarative-code.png"),
    modifier = Modifier.fillMaxHeight(0.8f).padding(top = 100.dp),
    footer = { Footer() },
)

@Composable
private fun DeclarativeDefinition() = TitleSlide(
    title = "Deklarative UI",
    footer = { Footer() },
    content = {
        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f),
            contentAlignment = Alignment.Center
        ) {
            CaptionContent(
                title = "Fokus auf das WAS",
                subtitle = "Was ist das gewünschte Aussehen der UI"
            )
        }
    }
)

@Composable
private fun Demo() = CaptionSlide(
    title = "Demo",
    //subtitle = "\"Talk is cheap. Show me the code.\" - Linus Torvalds",
    contentModifier = Modifier.fillMaxWidth(0.6f),
    background = {
        Image(
            painter = painterResource("$PRESENTATION_RESOURCE_DIR/background.png"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
)

// TODO: Expand and revise
@Composable
private fun Ecosystem() = ListSlide(
    title = "Ökosystem",
    bulletPoint = null,
    footer = { Footer() },
    items = listOf(
        // TODO: Bullet Points
    )
)

// TODO: Expand and revise
@Composable
private fun Conclusion() = ListSlide(
    title = "Ökosystem",
    bulletPoint = null,
    footer = { Footer() },
    items = listOf(
        // TODO: Bullet Points
    )
)

// TODO: Expand and revise
@Composable
private fun Resources() = ListSlide(
    title = "Ökosystem",
    bulletPoint = null,
    footer = { Footer() },
    items = listOf(
        // TODO: Bullet Points
    )
)


@Composable
private fun Questions() = CaptionSlide(
    title = "Fragen?",
    contentModifier = Modifier.fillMaxWidth(0.6f),
    background = {
        Image(
            painter = painterResource("$PRESENTATION_RESOURCE_DIR/background.png"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
)

@Composable
private fun Footer() {
    Divider(thickness = 16.dp, color = MaterialTheme.colors.primary)
}
