package com.aschiesch.dspiel.ui.learn

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aschiesch.dspiel.R
import com.aschiesch.dspiel.ui.theme.WDeutschTheme
import kotlinx.serialization.Serializable

@Serializable
object LearnHomeScreen

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LearnHomeScreen(
    onPresentTenseClicked: () -> Unit = {}
) {
    FlowRow (
        modifier = Modifier.fillMaxSize(),
        maxItemsInEachRow = 2,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        LearnItem(
            title = stringResource(R.string.present_tense_title),
            onClick = {
                onPresentTenseClicked()
            },
            modifier = Modifier.weight(1f)
        )
    }
}


@Composable
fun LearnItem(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColors = listOf(
        MaterialTheme.colorScheme.secondaryContainer,
        MaterialTheme.colorScheme.tertiaryContainer
    )
    val backgroundBrush = Brush.linearGradient(
        colors = backgroundColors
    )
    Box(
        modifier = modifier
            .height(128.dp)
            .padding(8.dp)
            .background(
            brush = backgroundBrush,
            shape = MaterialTheme.shapes.medium
        )
            .clickable {
            onClick()
        }.padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                color = MaterialTheme.colorScheme.onSecondaryContainer
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewLearnHomeScreen() {
    WDeutschTheme {
        Surface {
            LearnHomeScreen {

            }
        }
    }
}