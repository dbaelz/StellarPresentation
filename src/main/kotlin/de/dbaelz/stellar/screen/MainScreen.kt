package de.dbaelz.stellar.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.dbaelz.stellar.feature.presentation.Presentation
import de.dbaelz.stellar.theme.IndieFlower

@Composable
fun MainScreen(
    presentations: List<Presentation> = emptyList(),
    onPresentationSelected: (Presentation) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            // TODO: Switch with Stellar Presentation icon
            painter = painterResource("images/compose-logo.png"),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(0.15f)
        )

        Text(
            text = "Stellar Presentation",
            style = MaterialTheme.typography.h1,
            fontFamily = IndieFlower
        )

        Spacer(Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .border(2.dp, MaterialTheme.colors.primaryVariant, RoundedCornerShape(16.dp))
        ) {
            Text(
                text = "Presentations:",
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(8.dp)
            )

            presentations.forEach { presentation ->
                Divider(thickness = 2.dp, color = MaterialTheme.colors.primaryVariant)

                BoxWithTooltip(tooltip = {
                    Text(
                        text = presentation.description,
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.onSecondary,
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colors.secondary)
                            .padding(8.dp)
                    )
                }) {
                    Row(
                        Modifier.fillMaxWidth()
                            .clickable {
                                onPresentationSelected(presentation)
                            }.padding(8.dp)
                    )
                    {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = MaterialTheme.colors.secondary,
                            modifier = Modifier.size(40.dp).align(Alignment.CenterVertically)
                        )

                        Text(
                            text = presentation.title,
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.onSurface
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(32.dp))
    }
}