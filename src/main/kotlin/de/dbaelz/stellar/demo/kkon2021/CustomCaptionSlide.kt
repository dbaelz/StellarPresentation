package de.dbaelz.stellar.demo.kkon2021

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.dbaelz.stellar.feature.presentation.CaptionContent
import de.dbaelz.stellar.feature.presentation.CaptionSlide
import de.dbaelz.stellar.theme.MarkaziText


@Composable
fun CustomCaptionWithAuthorSlide() {
    CaptionSlide(
        modifier = Modifier.fillMaxSize(),
        footer = {},
        content = {
            Image(
                painter = painterResource("images/compose-desktop-logo.png"),
                contentDescription = null,
                modifier = Modifier.fillMaxSize().alpha(0.6f)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(84.dp))

                CaptionContent(
                    title = "Compose for Desktop",
                    backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.8f),
                    contentColor = MaterialTheme.colors.onPrimary,
                    contentModifier = Modifier
                        .fillMaxWidth(0.8f)
                        .border(8.dp, Color.DarkGray, RoundedCornerShape(32.dp))
                )

                Spacer(Modifier.height(32.dp))

                SpeakerInfo()
            }
        })
}

@Composable
private fun SpeakerInfo() {
    Row(
        modifier = Modifier
            .border(4.dp, Color.DarkGray, RoundedCornerShape(32.dp))
            .clip(RoundedCornerShape(32.dp))
            .background(MaterialTheme.colors.secondaryVariant.copy(alpha = 0.9f))
    ) {
        val size = 128.dp
        val rowModifier = Modifier.height(size)

        Image(
            painter = painterResource("$PRESENTATION_RESOURCE_DIR/avatar.png"),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = rowModifier.size(size)
                .clip(RoundedCornerShape(topStart = 32.dp, bottomStart = 32.dp))
        )

        VerticalDivider(rowModifier)

        CompositionLocalProvider(
            LocalTextStyle provides MaterialTheme.typography.h4.copy(
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = MarkaziText,
            )
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = rowModifier
            ) {
                Text("Daniel Bälz")
            }


            VerticalDivider(rowModifier)

            Column(
                modifier = rowModifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text("Android Entwickler")

                Text("inovex GmbH")
            }

            VerticalDivider(rowModifier)

            Column(
                modifier = rowModifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Twitter/GitHub/Dev.to")

                Text(text = "@dbaelz")
            }

            VerticalDivider(rowModifier)

            Box(
                contentAlignment = Alignment.Center,
                modifier = rowModifier.padding(end = 24.dp)
            ) {
                Text(
                    text = "https://dbaelz.de"
                )
            }
        }
    }
}

@Composable
private fun VerticalDivider(modifier: Modifier = Modifier) {
    Divider(
        color = Color.DarkGray,
        modifier = modifier.padding(horizontal = 16.dp).width(4.dp)
    )
}