package de.dbaelz.stellar.screen

import androidx.compose.foundation.BoxWithTooltip
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.dbaelz.stellar.feature.presentation.Presentation

@Composable
fun MainScreen(
    presentations: List<Presentation> = emptyList(),
    onPresentationSelected: (Presentation) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Stellar Presentation", style = MaterialTheme.typography.h1)

        Spacer(Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .border(2.dp, MaterialTheme.colors.primaryVariant)
        ) {
            Text(
                text = "Presentations:",
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(4.dp)
            )

            Divider(thickness = 2.dp, color = MaterialTheme.colors.primaryVariant)

            presentations.forEach { presentation ->
                BoxWithTooltip(tooltip = {
                    Text(
                        text = presentation.description,
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.onSecondary,
                        modifier = Modifier
                            .background(MaterialTheme.colors.secondary)
                            .padding(4.dp)
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
                            tint = MaterialTheme.colors.onSecondary,
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
    }
}