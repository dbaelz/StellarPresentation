package de.dbaelz.stellar.feature.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AboutSlide(
    name: String,
    modifier: Modifier = Modifier,
    designation: String? = null,
    info: @Composable ColumnScope.() -> Unit = {},
    statement: String? = null,
    footer: @Composable () -> Unit = {},
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))

            // Name and designation
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colors.primary.copy(alpha = 0.8f),
                contentColor = MaterialTheme.colors.onPrimary,
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.h3,
                        textAlign = TextAlign.Center
                    )

                    if (designation != null) {
                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = designation,
                            style = MaterialTheme.typography.h4,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            info()

            Spacer(Modifier.height(16.dp))

            if (statement != null) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colors.secondary.copy(alpha = 0.8f),
                    contentColor = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Box(Modifier.padding(32.dp)) {

                        Text(
                            text = statement,
                            style = MaterialTheme.typography.h4,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.wrapContentWidth()
                        )
                    }
                }

                Spacer(Modifier.height(32.dp))
            }
        }


        Footer(Modifier.align(Alignment.BottomCenter), footer)
    }
}