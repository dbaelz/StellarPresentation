package de.dbaelz.stellar.demo.kkon2021

import androidx.compose.foundation.ExperimentalDesktopApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.dbaelz.stellar.demo.kkon2021.example.DeclarativeImperativeExample
import de.dbaelz.stellar.feature.presentation.*
import de.dbaelz.stellar.theme.LatoTypography

internal const val PRESENTATION_RESOURCE_DIR = "presentation/kkon2021"

private const val IMPERATIVE_UI_TITLE = "Imperative UI:"
private const val DECLARATIVE_UI_TITLE = "Deklarative UI:"

@ExperimentalDesktopApi
@ExperimentalComposeUiApi
@Composable
fun createComposeForDesktopPresentation(): Presentation {
    return Presentation(
        title = "Compose for Desktop",
        description = "KKON 2021: Compose for Desktop",
        typography = LatoTypography,
        slides = listOf(
            { CustomCaptionWithAuthorSlide() },

            { ComposeForDesktopDefinition() },


            { DeclarativeImperativeStory() },
            { ImperativeFunctionCode() },
            { ImperativeDefinition() },
            { DeclarativeCode() },
            { DeclarativeDefinition() },
            { WhyDeclarative() },


            { ComposeForDesktopFacts() },
            { ComposeForDesktopIntro() },


            { ComposeForDesktopExampleCounterButton() },
            { DesktopAPIs() },
            { ComposeForDesktopExampleWindow() },
            { ComposeForDesktopExampleMouseKeyboard() },
            { ComposeForDesktopExampleInteropSwing() },


            //{ GettingStarted() }, TODO: Getting started with info how start?

            { Distribution() },

            { Outlook() },
            { Conclusion() },
            { Resources() },
            { Questions() },
        )
    )
}

@Composable
private fun ComposeForDesktopDefinition() = CaptionSlide(
    title = "„Compose for Desktop bietet einen deklarativen und reaktiven Ansatz zur Erstellung " +
            "von Benutzeroberflächen mit Kotlin”",
    subtitle = "https://www.jetbrains.com/lp/compose/",
    titleTextStyle = defaultCaptionTitleStyle.copy(fontSize = 70.sp, fontStyle = FontStyle.Italic),
    subtitleTextStyle = defaultCaptionTitleStyle.copy(fontSize = 28.sp),
    contentModifier = Modifier
        .fillMaxWidth(0.75f)
        .border(4.dp, Color.Gray, RoundedCornerShape(32.dp)),
    background = {
        Image(
            painter = painterResource("$PRESENTATION_RESOURCE_DIR/background.png"),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
)

@Composable
private fun DeclarativeImperativeStory() = TitleSlide(
    title = "Deklarative und Imperative UI",
    footer = { Footer() },
    content = {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(32.dp).fillMaxSize()
        ) {
            Surface(
                shape = RoundedCornerShape(32.dp),
                color = MaterialTheme.colors.secondary.copy(alpha = 0.8f),
                contentColor = MaterialTheme.colors.onSecondary,
                modifier = Modifier.border(4.dp, Color.Gray, RoundedCornerShape(32.dp))
            ) {
                Column(modifier = Modifier.padding(32.dp)) {
                    Text(
                        text = "Abhängig vom Zahlenwert soll sich die Darstellung ändern",
                        style = MaterialTheme.typography.h3,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(16.dp)
                    )

                    Spacer(Modifier.height(32.dp))

                    StoryText("0:", "Schrift in Schwarz, Rahmen in Schwarz")
                    StoryText("1..5:", "Schrift in Grün, kein Rahmen")
                    StoryText("6..10:", "Schrift in Rot, kein Rahmen")
                    StoryText(">= 11:", "Schrift in Rot, Rahmen in Rot")
                }
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                DeclarativeImperativeExample(Modifier.padding(8.dp))
            }
        }
    }
)

@Composable
private fun StoryText(range: String, text: String) {
    Row(modifier = Modifier.padding(start = 32.dp)) {
        Text(
            text = range,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(200.dp)
        )

        Text(
            text = text,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Start
        )
    }

}


@Composable
private fun ImperativeFunctionCode() = ImageSlide(
    title = "$IMPERATIVE_UI_TITLE Code",
    image = painterResource("$PRESENTATION_RESOURCE_DIR/imperative-function-code.png"),
    modifier = Modifier
        .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(16.dp))
        .padding(2.dp)
        .clip(RoundedCornerShape(16.dp)),
    footer = { Footer() },
)

@Composable
private fun ImperativeDefinition() = KeySentenceSlide(
    title = "$IMPERATIVE_UI_TITLE Definition",
    captionTitle = "Fokus auf das WIE",
    captionSubtitle = "Wie muss sich die UI verändern",
    footer = { Footer() }
)

@Composable
private fun DeclarativeCode() = ImageSlide(
    title = "$DECLARATIVE_UI_TITLE Code",
    image = painterResource("$PRESENTATION_RESOURCE_DIR/declarative-code.png"),
    contentScale = ContentScale.Inside,
    modifier = Modifier
        .scale(1.2f)
        .border(4.dp, MaterialTheme.colors.primary, RoundedCornerShape(16.dp))
        .padding(2.dp)
        .clip(RoundedCornerShape(16.dp)),
    footer = { Footer() },
)

@Composable
private fun DeclarativeDefinition() = KeySentenceSlide(
    title = "$DECLARATIVE_UI_TITLE Definition",
    captionTitle = "Fokus auf das WAS",
    captionSubtitle = "Was ist das gewünschte Aussehen der UI",
    footer = { Footer() }
)

@Composable
private fun WhyDeclarative() = ListSlide(
    title = "$DECLARATIVE_UI_TITLE Vorteile",
    footer = { Footer() },
    items = listOf(
        "Verständlicher und weniger fehleranfälliger Code",
        "Vereinfachte Architektur mit unidirektionalem Datenfluss",
        "Flexible Komposition von UI-Elementen wird gefördert"
    )
)


@Composable
private fun ComposeForDesktopFacts() = ListSlide(
    title = "Compose for Desktop",
    footer = { Footer() },
    items = listOf(
        "Deklaratives UI Toolkit",
        "Basierend auf Jetpack Compose (Android)",
        "Zielplattform: macOS, Windows, Linux",
        "Entwickelt von JetBrains",
        "Aktuell in der Alpha"
    )
)

@Composable
private fun ComposeForDesktopIntro() = LeftRightSlide(
    title = "Compose for Desktop",
    footer = { Footer() },
    leftContent = {
        ContentListItems(
            itemsArrangement = Arrangement.SpaceEvenly,
            items = listOf(
                "Deklarative UI",
                "UI definiert im Kotlin Code",
                "Komposition mittels Funktionen",
                "State Handling"
            )
        )
    },
    rightContent = {
        ImageItem(image = painterResource("$PRESENTATION_RESOURCE_DIR/example/counter-button.png"))
    }
)


/*
@Composable
private fun GettingStarted() = CaptionSlide(
    title = "",
    contentModifier = Modifier
        .fillMaxWidth(0.6f)
        .border(2.dp, Color.Gray, RoundedCornerShape(32.dp)),
    background = {
        Image(
            painter = painterResource("$PRESENTATION_RESOURCE_DIR/background.png"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
)
*/


// TODO: Fix bullet point (or remove them?)
@Composable
private fun Distribution() = ListSlide(
    title = "Compose for Desktop: Distribution",
    footer = { Footer() },
    items = listOf(
        "Konfigurierbares Gradle Plugin",
        "Java Runtime wird mit ausgeliefert",
        "Formate:\n" +
                "    • macOS: dmg & pkg\n" +
                "    • Windows: exe & msi\n" +
                "    • Linux: deb & rpm"


    )
)

// TODO: Expand and revise.
//  Ecosystem and libraries
//  Multiplatform & Web
@Composable
private fun Outlook() = ListSlide(
    title = "Compose for Desktop: Ausblick",
    footer = { Footer() },
    items = listOf(
        ""
        // TODO: Bullet Points
    )
)

// TODO: Expand and revise
@Composable
private fun Conclusion() = ListSlide(
    title = "Compose for Desktop: Fazit",
    footer = { Footer() },
    items = listOf(
        "Bietet bereits viele Möglichkeiten",
        "Hat noch Bugs und fehlende Feature",
        "Ökosystem wächst langsam, auch durch Jetpack Compose",
        "Mein Tipp: Einfach ausprobieren"
    )
)

// TODO: Expand and revise
@Composable
private fun Resources() = ListSlide(
    title = "Compose for Desktop: Ressourcen",
    footer = { Footer() },
    items = listOf(
        "Projekt: https://www.jetbrains.com/lp/compose/",
        "Tutorials: https://github.com/JetBrains/compose-jb/tree/master/tutorials",
        "Jetpack Compose: https://developer.android.com/jetpack/compose",
        "Kotlin Slack: https://surveys.jetbrains.com/s3/kotlin-slack-sign-up"
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
internal fun Footer() {
    Divider(thickness = 16.dp, color = MaterialTheme.colors.primary)
}
